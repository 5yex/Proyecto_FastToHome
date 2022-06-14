package com.proyecto.fasttohome.vista.pedido;

import static com.proyecto.fasttohome.util.Texto.leftPad;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.AutoResolveHelper;
import com.google.android.gms.wallet.PaymentData;

import com.google.gson.Gson;
import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.databinding.ActivityFinalizarPedidoBinding;

import com.proyecto.fasttohome.modelo.Cesta;
import com.proyecto.fasttohome.modelo.Negocio;
import com.proyecto.fasttohome.modelo.Pedido;
import com.proyecto.fasttohome.modelo.Peticion;
import com.proyecto.fasttohome.modelo.Producto;
import com.proyecto.fasttohome.modelo.Usuario;
import com.proyecto.fasttohome.util.CheckoutViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FinalizarPedido extends AppCompatActivity {

    // Arbitrarily-picked constant integer you define to track a request for payment data activity.
    private static final int LOAD_PAYMENT_DATA_REQUEST_CODE = 991;

    private CheckoutViewModel model;

    private ActivityFinalizarPedidoBinding layoutBinding;
    private View googlePayButton;

    private HashMap<Integer, Integer> productosSeleccionados;
    private HashMap<Integer, Producto> productos;
    private Usuario usuario;
    private Negocio negocio;
    private Pedido pedido;
    private ListView listaProductos;
    private TextView total;
    

    private int centimos;

    /**
     * Initialize the Google Pay API on creation of the activity
     *
     * @see AppCompatActivity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usuario = (Usuario) getIntent().getExtras().getSerializable("usuario");
        negocio = (Negocio) getIntent().getExtras().getSerializable("negocio");
        pedido = (Pedido) getIntent().getExtras().getSerializable("pedido");
        productos = (HashMap<Integer, Producto>) getIntent().getExtras().getSerializable("productos");
        productosSeleccionados = (HashMap<Integer, Integer>) getIntent().getExtras().getSerializable("productosSeleccionados");

        initializeUi();

        model = new ViewModelProvider(this).get(CheckoutViewModel.class);
        model.canUseGooglePay.observe(this, this::setGooglePayAvailable);
    }

    private void initializeUi() {

        // Use view binding to access the UI elements
        layoutBinding = ActivityFinalizarPedidoBinding.inflate(getLayoutInflater());
        setContentView(layoutBinding.getRoot());

        // The Google Pay button is a layout file – take the root view
        googlePayButton = layoutBinding.googlePayButton.getRoot();
        googlePayButton.setOnClickListener(this::requestPayment);

        total = findViewById(R.id.detailPrice);

        actualizarResumen();

    }

    private void actualizarResumen() {
        ArrayList<String> lista = new ArrayList<>();
        double precioTotal = 0;
        int indice = 0;
        for (Map.Entry<Integer, Integer> entry : productosSeleccionados.entrySet()) {
            Producto producto = productos.get(entry.getKey());
            precioTotal = precioTotal + (producto.getPrecio() * entry.getValue());
            lista.add(leftPad("€" + producto.getPrecio(), 5) + leftPad("  Uds: " + entry.getValue(), 12) + "  " + producto.getNombre());
            indice++;
        }
        total.setText(String.valueOf(precioTotal + " Euros"));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listaProductos = findViewById(R.id.list);
        listaProductos.setAdapter(adapter);
        centimos = (int) (precioTotal * 100);
        pedido.setTotal(precioTotal);
    }
    /**
     * If isReadyToPay returned {@code true}, show the button and hide the "checking" text.
     * Otherwise, notify the user that Google Pay is not available. Please adjust to fit in with
     * your current user flow. You are not required to explicitly let the user know if isReadyToPay
     * returns {@code false}.
     *
     * @param available isReadyToPay API response.
     */
    private void setGooglePayAvailable(boolean available) {
        if (available) {
            googlePayButton.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this, R.string.googlepay_status_unavailable, Toast.LENGTH_LONG).show();
        }
    }

    public void requestPayment(View view) {

        // Disables the button to prevent multiple clicks.

        googlePayButton.setClickable(false);

        // The price provided to the API should include taxes and shipping.
        // This price is not displayed to the user.

        final Task<PaymentData> task = model.getLoadPaymentDataTask(centimos);

        // Shows the payment sheet and forwards the result to the onActivityResult method.
        AutoResolveHelper.resolveTask(task, this, LOAD_PAYMENT_DATA_REQUEST_CODE);
    }

    /**
     * Handle a resolved activity from the Google Pay payment sheet.
     *
     * @param requestCode Request code originally supplied to AutoResolveHelper in requestPayment().
     * @param resultCode  Result code returned by the Google Pay API.
     * @param data        Intent from the Google Pay API containing payment or error data.
     * @see <a href="https://developer.android.com/training/basics/intents/result">Getting a result
     * from an Activity</a>
     */
    @SuppressWarnings("deprecation")
    // Suppressing deprecation until `registerForActivityResult` can be used with the Google Pay API.
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            // value passed in AutoResolveHelper
            case LOAD_PAYMENT_DATA_REQUEST_CODE:
                switch (resultCode) {

                    case AppCompatActivity.RESULT_OK:
                        PaymentData paymentData = PaymentData.getFromIntent(data);
                        handlePaymentSuccess(paymentData);
                        pedidoAfterPay();
                        break;

                    case AppCompatActivity.RESULT_CANCELED:
                        // The user cancelled the payment attempt
                        break;

                    case AutoResolveHelper.RESULT_ERROR:
                        Status status = AutoResolveHelper.getStatusFromIntent(data);
                        handleError(status);
                        break;
                }

                // Re-enables the Google Pay payment button.
                googlePayButton.setClickable(true);
        }
    }

    /**
     * PaymentData response object contains the payment information, as well as any additional
     * requested information, such as billing and shipping address.
     *
     * @param paymentData A response object returned by Google after a payer approves payment.
     * @see <a href="https://developers.google.com/pay/api/android/reference/
     * object#PaymentData">PaymentData</a>
     */
    private void handlePaymentSuccess(@Nullable PaymentData paymentData) {
        final String paymentInfo = paymentData.toJson();

        try {
            JSONObject paymentMethodData = new JSONObject(paymentInfo).getJSONObject("paymentMethodData");
            // If the gateway is set to "example", no payment information is returned - instead, the
            // token will only consist of "examplePaymentMethodToken".

            final JSONObject tokenizationData = paymentMethodData.getJSONObject("tokenizationData");
            final String token = tokenizationData.getString("token");
            final JSONObject info = paymentMethodData.getJSONObject("info");
            final String billingName = info.getJSONObject("billingAddress").getString("name");
            Toast.makeText(
                    this, getString(R.string.payments_show_name, billingName),
                    Toast.LENGTH_LONG).show();

            // Logging token string.
            Log.d("Google Pay token: ", token);

        } catch (JSONException e) {
            throw new RuntimeException("The selected garment cannot be parsed from the list of elements");
        }
    }

    /**
     * At this stage, the user has already seen a popup informing them an error occurred. Normally,
     * only logging is required.
     *
     * @param status will hold the value of any constant from CommonStatusCode or one of the
     *               WalletConstants.ERROR_CODE_* constants.
     * @see <a href="https://developers.google.com/android/reference/com/google/android/gms/wallet/
     * WalletConstants#constant-summary">Wallet Constants Library</a>
     */
    private void handleError(@Nullable Status status) {
        String errorString = "Unknown error.";
        if (status != null) {
            int statusCode = status.getStatusCode();
            errorString = String.format(Locale.getDefault(), "Error code: %d", statusCode);
        }

        Log.e("loadPaymentData failed", errorString);
    }

    private void pedidoAfterPay() {
        productos = new HashMap<>();
        String url = getString(R.string.apiUrl);
        RequestQueue queue = Volley.newRequestQueue(FinalizarPedido.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            System.out.println(response);
            try {
                JSONObject resp = new JSONObject(response);
                if ((resp.getBoolean("error")) == true) {
                    throw new VolleyError(resp.getString("datos"));
                } else {
                    Intent i = new Intent(this, PedidoFinalizado.class );
                    i.putExtra("user", usuario);
                    startActivity(i);
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(FinalizarPedido.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                finish();
            }
        }, volleyError -> {
            Toast.makeText(FinalizarPedido.this, "ERROR DE CONEXIÓN = " + volleyError, Toast.LENGTH_SHORT).show();
            finish();
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                ArrayList<Object> DatosPedido = new ArrayList<>();
                DatosPedido.add(pedido);
                DatosPedido.add(getCesta());
                params.put("DATA", new Peticion("nuevo_pedido", new Gson().toJson(DatosPedido)).getJSON());
                return params;
            }
        };
        queue.add(request);
    }

    @NonNull
    private ArrayList<Cesta> getCesta() {
        ArrayList<Cesta> ProductosPedido = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : productosSeleccionados.entrySet()) {
            ProductosPedido.add(new Cesta(entry.getKey(),pedido.getId_pedido(),entry.getValue()));
        }
        return ProductosPedido;
    }

}