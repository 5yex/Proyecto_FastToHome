package com.donosocortes.fast2home.vista.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
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
import com.donosocortes.fast2home.vista.login.PantallaLogin;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paso_direccion_final);

        user = (Usuario) getIntent().getExtras().getSerializable("user");
        direccion = (Direccion) getIntent().getExtras().getSerializable("direccion");

        calle =  findViewById(R.id.etCalle);
        numero = findViewById(R.id.etNumero);
        codigoPostal = findViewById(R.id.etCodigoPostal);
        ciudad = findViewById(R.id.etCiudad);
        otros = findViewById(R.id.etOtros);
        System.err.println(user.getJSON()+direccion.getJSON());


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
    }

    /**
     * Registra un usuario llamando a la api rest con volley
     *
     */

    public void accionRegistro(View view){
        direccion.setNumero(Integer.valueOf(numero.getText().toString()));
        direccion.setCodigo_postal(Integer.valueOf(codigoPostal.getText().toString()));
        direccion.setCiudad(ciudad.getText().toString());
        direccion.setCalle(calle.getText().toString());
        direccion.setOtros(otros.getText().toString());

        System.err.println(user.getJSON()+direccion.getJSON());
        registerDirecion();
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
                    if (DireccionId != -1){
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

    public void volverPantallaLogin(){
        Intent i = new Intent(this, PantallaLogin.class );

        //Para facilitar el inicio de sesión una vez registrado
        i.putExtra("email",user.getEmail());
        startActivity(i);
    }
}