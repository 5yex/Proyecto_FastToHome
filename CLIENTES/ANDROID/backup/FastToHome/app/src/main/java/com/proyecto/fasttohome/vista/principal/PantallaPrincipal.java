package com.proyecto.fasttohome.vista.principal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Peticion;
import com.proyecto.fasttohome.modelo.Usuario;
import com.proyecto.fasttohome.vista.login.PantallaLogin;

import org.json.JSONException;
import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

import java.util.HashMap;
import java.util.Map;

public class PantallaPrincipal extends AppCompatActivity {

    private Usuario user;
    private TextView nombre,apellidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pantalla_principal);

        user = (Usuario) getIntent().getExtras().getSerializable("user");
        nombre = (TextView) findViewById(R.id.ppNombre);
        apellidos = (TextView) findViewById(R.id.ppApellidos);
        obtenerDatosUsuario();
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
                    recargarVista();
                }

            } catch (JSONException | VolleyError e) {
                Toast.makeText(PantallaPrincipal.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
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

    private void recargarVista() {
        nombre.setText(user.getNombre());
        apellidos.setText(user.getApellidos());
    }


    private void onErrorResponse(VolleyError error) {
        Toast.makeText(PantallaPrincipal.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show();
        finish();
    }
}