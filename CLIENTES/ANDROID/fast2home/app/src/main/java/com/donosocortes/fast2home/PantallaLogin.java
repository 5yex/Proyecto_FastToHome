package com.donosocortes.fast2home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.donosocortes.fast2home.modelo.Peticion;
import com.donosocortes.fast2home.modelo.Usuario;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PantallaLogin extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_login);
        email = findViewById(R.id.eTEmail);
        password = findViewById(R.id.eTPassword);
    }

    public void comprobarPass(View view) {
        String url = "http://10.0.2.2/php/webService/api.php";
        RequestQueue queue = Volley.newRequestQueue(PantallaLogin.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);

                try {
                    if((new JSONObject(response).getBoolean("error")) == true){
                        new VolleyError("Error de login");
                    }

                    JSONObject resp = new JSONObject(response).getJSONObject("datos");
                    user.setPassword(resp.getString("password"));
                    user.setId(resp.getInt("id"));
                    Toast.makeText(PantallaLogin.this, user.toString(), Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PantallaLogin.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show()
            };
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                user = new Usuario();
                user.setEmail(email.getText().toString());
                params.put("DATA", new Peticion("getHash", user.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }
}


