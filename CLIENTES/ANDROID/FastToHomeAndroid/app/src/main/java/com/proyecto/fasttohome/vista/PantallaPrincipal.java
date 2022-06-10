package com.proyecto.fasttohome.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.proyecto.fasttohome.vista.pedido.PantallaDeNegocios;
import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Peticion;
import com.proyecto.fasttohome.modelo.Usuario;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PantallaPrincipal extends AppCompatActivity {

    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pantalla_principal);

        user = (Usuario) getIntent().getExtras().getSerializable("user");
        obtenerDatosUsuario();
        System.out.println("User: " + user.toString());
    }

    public void obtenerDatosUsuario() {
        String url = getString(R.string.apiUrl);
        RequestQueue queue = Volley.newRequestQueue(PantallaPrincipal.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            System.out.println(response);
            try {
                JSONObject resp = new JSONObject(response);
                if ((resp.getBoolean("error")) == true) {
                    throw new VolleyError(resp.getString("datos"));
                } else {
                    JSONObject datos = resp.getJSONArray("datos").getJSONObject(0);
                    user.setPassword(datos.getString("password"));
                    user.setId(datos.getInt("id"));
                    user.setEmail(datos.getString("Email"));
                    user.setNombre(datos.getString("Nombre"));
                    user.setApellidos(datos.getString("apellidos"));
                    user.setDni(datos.getString("Dni"));
                    user.setId_direccion(datos.getInt("direccion_id"));
                    user.setRol(datos.getString("Rol"));
                    user.setTlf(datos.getString("tlf"));

                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(PantallaPrincipal.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
                finish();
            }
        }, this::onErrorResponse) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("DATA", new Peticion("getUsuario", user.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }


    private void onErrorResponse(VolleyError error) {
        Toast.makeText(PantallaPrincipal.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show();
        finish();
    }

    public void pasarPantallaNegocios(View view){
        Intent i = new Intent(this, PantallaDeNegocios.class );
        i.putExtra("user",user);
        startActivity(i);
    }
}