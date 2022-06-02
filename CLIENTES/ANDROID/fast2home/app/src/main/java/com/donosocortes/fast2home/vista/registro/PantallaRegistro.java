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
import org.mindrot.jbcrypt.BCrypt;

import java.util.HashMap;
import java.util.Map;

public class PantallaRegistro extends AppCompatActivity {
    Usuario user = new Usuario();
    Direccion direccion = new Direccion();
    EditText nombre;
    EditText apellidos;
    EditText dni;
    EditText telefono;

    EditText email;
    EditText password;
    EditText passwordConfirm;

    EditText calle;
    EditText numero;
    EditText codigoPostal;
    EditText ciudad;
    EditText otros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        email = findViewById(R.id.eTEmail);
        nombre = findViewById(R.id.etNombre);
        apellidos = findViewById(R.id.etApellidos);
        dni = findViewById(R.id.etDni);
        telefono = findViewById(R.id.etTelefono);
        password = findViewById(R.id.etPassword);
        passwordConfirm = findViewById(R.id.etPasswordConfirm);
        calle = (EditText) findViewById(R.id.etCalle);
        numero = findViewById(R.id.etNumero);
        codigoPostal = findViewById(R.id.etCodigoPostal);
        ciudad = findViewById(R.id.etCiudad);
        otros = findViewById(R.id.etOtros);

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
     *
     */

    public void accionRegistro(View view){
        registerDirecion();
    }

    private void registerCompleter(int idDireccion) {
        String url = "http://10.0.2.2/php/webService/api.php";
        RequestQueue queue = Volley.newRequestQueue(PantallaRegistro.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            System.out.println(response);
            try {
                JSONObject resp = new JSONObject(response);
                if ((resp.getBoolean("error")) == true) {
                    throw new VolleyError(resp.getString("datos"));
                } else {
                    Toast.makeText(PantallaRegistro.this, "Registro Completado Con Éxito", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(PantallaRegistro.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, error -> Toast.makeText(PantallaRegistro.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                user.setEmail(email.getText().toString());
                user.setPassword(BCrypt.hashpw(password.getText().toString(), BCrypt.gensalt(10)));
                user.setApellidos(apellidos.getText().toString());
                user.setDni(dni.getText().toString());
                user.setNombre(nombre.getText().toString());
                user.setTlf(telefono.getText().toString());
                user.setId_direccion(idDireccion);
                params.put("DATA", new Peticion("nuevo_usuario", user.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }

    private void registerDirecion() {
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
                    int DireccionId = datos.getInt("last_id");
                    if (DireccionId != -1){
                        registerCompleter(DireccionId);
                    }
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(PantallaRegistro.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, error -> Toast.makeText(PantallaRegistro.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                direccion.setCalle(calle.getText().toString());
                direccion.setCiudad(ciudad.getText().toString());
                direccion.setCodigo_postal(Integer.parseInt(codigoPostal.getText().toString()));
                direccion.setNumero(Integer.parseInt(numero.getText().toString()));
                direccion.setOtros(otros.getText().toString());
                params.put("DATA", new Peticion("nueva_direccion_devuelve_id", direccion.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }
}