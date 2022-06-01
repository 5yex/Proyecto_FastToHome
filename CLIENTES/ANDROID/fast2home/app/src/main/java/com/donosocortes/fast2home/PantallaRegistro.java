package com.donosocortes.fast2home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.donosocortes.fast2home.modelo.Direccion;
import com.donosocortes.fast2home.modelo.Peticion;
import com.donosocortes.fast2home.modelo.Usuario;

import org.json.JSONException;
import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

import java.util.HashMap;
import java.util.Map;

public class PantallaRegistro extends AppCompatActivity {
    Usuario user = null;
    Direccion direccion = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_registro);

    }

    public void nextStepDireccion(View view) {
        setContentView(R.layout.activity_pantalla_registro_direccion);
    }

    public void lastStepUsuario(View view) {
        setContentView(R.layout.activity_pantalla_registro);
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