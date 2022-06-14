package com.proyecto.fasttohome.vista.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Direccion;
import com.proyecto.fasttohome.modelo.Peticion;
import com.proyecto.fasttohome.modelo.Usuario;
import com.proyecto.fasttohome.vista.PantallaPrincipal;
import com.proyecto.fasttohome.vista.login.PantallaLogin;
import com.proyecto.fasttohome.vista.pedido.seleccionarTransporteZona;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class registroPaso3Direccion extends AppCompatActivity {
    Usuario user;
    Direccion direccion;
    EditText calle;
    EditText numero;
    EditText codigoPostal;
    EditText ciudad;
    EditText otros;
    String funcion;
    TextView textoTitulo;
    Button botonActualizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getSupportActionBar().hide();
        setContentView(R.layout.activity_registro_paso_direccion_final);

        user = (Usuario) getIntent().getExtras().getSerializable("user");
        direccion = (Direccion) getIntent().getExtras().getSerializable("direccion");
        direccion.setCoordenadas(" ");
        calle = findViewById(R.id.etCalle);
        numero = findViewById(R.id.etNumero);
        codigoPostal = findViewById(R.id.etCodigoPostal);
        ciudad = findViewById(R.id.etCiudad);
        otros = findViewById(R.id.etOtros);
        botonActualizar = findViewById(R.id.buttonDireccion);

        funcion = getIntent().getExtras().getString("funcion");
        if (funcion.equals("update")) {
            textoTitulo = findViewById(R.id.textoTituloDireccion);
            textoTitulo.setText("Actualizar Direccion");
            calle.setText(direccion.getCalle());
            numero.setText(direccion.getNumero()+"");
            codigoPostal.setText(direccion.getCodigo_postal()+"");
            ciudad.setText(direccion.getCiudad());
            otros.setText(direccion.getOtros());
            botonActualizar.setText("ACTUALIZAR");

        }


    }

    /**
     * Registra un usuario llamando a la api rest con volley
     * https://maps.googleapis.com/maps/api/geocode/json?latlng=40.714224,-73.961452&key=AIzaSyCYF3r2xgvGA5oehQkJx3mCmOoRh6WNQvQ
     */

    public void accionRegistro(View view) {

        try {
            String numero_casa = numero.getText().toString();
            String cod_postal = codigoPostal.getText().toString();
            String city = ciudad.getText().toString();
            String street = calle.getText().toString();
            String other = otros.getText().toString();

            if (numero_casa.length() > 0 && cod_postal.length() > 0 && city.length() > 0 && street.length() > 0 && other.length() > 0) {
                int numeroEntero = Integer.valueOf(numero.getText().toString());
                int cod_postalEntero = Integer.valueOf(codigoPostal.getText().toString());

                direccion.setNumero(numeroEntero);
                direccion.setCodigo_postal(cod_postalEntero);
                direccion.setCiudad(ciudad.getText().toString());
                direccion.setCalle(calle.getText().toString());
                direccion.setOtros(otros.getText().toString());

                System.err.println(user.getJSON() + direccion.getJSON());

                if (funcion.equals("registro")) {
                    registerDirecion();
                }
                if (funcion.equals("update")) {
                    updateDireccion();
                }

                } else {
                Toast notificacion = Toast.makeText(this, "No debes dejar ningún campo vacío.", Toast.LENGTH_SHORT);
                notificacion.show();
            }
        } catch (NumberFormatException exception) {
            Toast notificacion = Toast.makeText(this, "El numero de la calle y el codigo postal deben ser numeros enteros.", Toast.LENGTH_SHORT);
            notificacion.show();
        }
    }

    private void registerCompleter(int idDireccion) {
        //Obtenemos la url del archivo strings.xml
        String url = getString(R.string.apiUrl);
        RequestQueue queue = Volley.newRequestQueue(registroPaso3Direccion.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            System.out.println(response);
            try {
                JSONObject resp = new JSONObject(response);
                if ((resp.getBoolean("error")) == true) {
                    throw new VolleyError(resp.getString("datos"));
                } else {
                    Toast.makeText(registroPaso3Direccion.this, "Registro Completado Con Éxito", Toast.LENGTH_SHORT).show();
                    volverPantallaLogin();
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(registroPaso3Direccion.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, error -> Toast.makeText(registroPaso3Direccion.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                user.setId_direccion(idDireccion);
                user.setRol("cliente");
                params.put("DATA", new Peticion("nuevo_usuario", user.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }

    private void registerDirecion() {
        String url = getString(R.string.apiUrl);
        RequestQueue queue = Volley.newRequestQueue(registroPaso3Direccion.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            System.out.println(response);
            try {
                JSONObject resp = new JSONObject(response);
                if ((resp.getBoolean("error")) == true) {
                    throw new VolleyError(resp.getString("datos"));
                } else {
                    JSONObject datos = resp.getJSONArray("datos").getJSONObject(0);
                    int DireccionId = datos.getInt("last_id");
                    if (DireccionId != -1) {
                        registerCompleter(DireccionId);
                    }
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(registroPaso3Direccion.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, error -> Toast.makeText(registroPaso3Direccion.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("DATA", new Peticion("nueva_direccion_devuelve_id", direccion.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }

    private void updateDireccion() {
       /* if(coordenadasActuales != null) {
            pararUbicacion = true;
            direccion.setCoordenadas(coordenadasActuales.latitude + "," + coordenadasActuales.longitude);
        }*/
        String url = getString(R.string.apiUrl);
        RequestQueue queue = Volley.newRequestQueue(registroPaso3Direccion.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            System.out.println(response);
            try {
                JSONObject resp = new JSONObject(response);
                if ((resp.getBoolean("error")) == true) {
                    throw new VolleyError(resp.getString("datos"));
                } else {
                    Toast.makeText(registroPaso3Direccion.this, "Se ha actualizado con éxito", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, PantallaPrincipal.class);
                    i.putExtra("user", user);
                    startActivity(i);
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(registroPaso3Direccion.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, error -> Toast.makeText(registroPaso3Direccion.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("DATA", new Peticion("actualizar_direccion", direccion.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }


    public void volverPantallaLogin() {
        Intent i = new Intent(this, PantallaLogin.class);
        i.putExtra("email", user.getEmail());
        startActivity(i);
    }
}