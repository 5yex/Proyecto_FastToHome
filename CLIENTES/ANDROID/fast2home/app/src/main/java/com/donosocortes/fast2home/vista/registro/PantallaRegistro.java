package com.donosocortes.fast2home.vista.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.donosocortes.fast2home.R;
import com.donosocortes.fast2home.modelo.Direccion;
import com.donosocortes.fast2home.modelo.Peticion;
import com.donosocortes.fast2home.modelo.Usuario;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PantallaRegistro extends AppCompatActivity {
    Usuario user = null;
    Direccion direccion = null;

    EditText nombre;
    EditText apellidos;
    EditText dni;
    EditText telefono;

    EditText password;
    EditText passwordConfirm;

    EditText calle;
    EditText numero;
    EditText codigoPostal;
    EditText ciudad;
    EditText otros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        nombre = (EditText) findViewById(R.id.etNombre);
        apellidos = (EditText) findViewById(R.id.etApellidos);
        dni = (EditText) findViewById(R.id.etDni);
        telefono = (EditText) findViewById(R.id.etTelefono);
        password = (EditText) findViewById(R.id.etPassword);
        passwordConfirm = (EditText) findViewById(R.id.etPasswordConfirm);
        calle = (EditText) findViewById(R.id.etCalle);
        numero = (EditText) findViewById(R.id.etNumero);
        codigoPostal = (EditText) findViewById(R.id.etCodigoPostal);
        ciudad = (EditText) findViewById(R.id.etCiudad);
        otros = (EditText) findViewById(R.id.etOtros);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_registro_paso1);

    }

    public void nextStepDireccion(View view) {
        setContentView(R.layout.activity_pantalla_registro_paso3);
    }

    public void nextStepPassword(View view) {
        setContentView(R.layout.activity_pantalla_registro_paso2);
    }

    public void lastStepUsuario(View view) {
        setContentView(R.layout.activity_pantalla_registro_paso1);
    }

    @Override
    public void onBackPressed() {

    }

    /**
     * Registra un usuario llamando a la api rest con volley
     * @param view
     */
    public void register(View view) {
        String url = "http://10.0.2.2/php/webService/api.php";
        RequestQueue queue = Volley.newRequestQueue(PantallaRegistro.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            System.out.println(response);
            try {
                JSONObject resp = new JSONObject(response);
                if ((resp.getBoolean("error")) == true) {
                    throw new VolleyError(resp.getString("datos"));
                } else {
                    JSONObject datos = resp.getJSONArray("datos").getJSONObject(0);

                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(PantallaRegistro.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, error -> Toast.makeText(PantallaRegistro.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                user = new Usuario();


                params.put("DATA", new Peticion("nuevo_usuario", user.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }
}