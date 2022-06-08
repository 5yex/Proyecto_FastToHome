package com.proyecto.fasttohome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.proyecto.fasttohome.modelo.Negocio;
import com.proyecto.fasttohome.modelo.Peticion;
import com.proyecto.fasttohome.modelo.Usuario;
import com.proyecto.fasttohome.recycler_adaptors.RecyclerViewAdaptorNegocio;
import com.proyecto.fasttohome.vista.login.PantallaLogin;
import com.proyecto.fasttohome.vista.principal.PantallaPrincipal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PantallaDeNegocios extends AppCompatActivity {

    private RecyclerView recyclerViewNegocio;
    private RecyclerViewAdaptorNegocio adaptorNegocio;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_de_negocios);

        recyclerViewNegocio=(RecyclerView) findViewById(R.id.recyclerNegocios);
        recyclerViewNegocio.setLayoutManager(new LinearLayoutManager(this));

        obtenerNegocios();
    }

    public void obtenerNegocios(){
        List<Negocio> negocios = new ArrayList<Negocio>();

        String url = getString(R.string.apiUrl);
        RequestQueue queue = Volley.newRequestQueue(PantallaDeNegocios.this);
        /*JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray arrayDeJson = response.getJSONArray("datos");

                            for (int i = 0; i < arrayDeJson.length(); i++){
                                JSONObject objetoNegocioJSon = arrayDeJson.getJSONObject(i);
                                Negocio negocio = new Negocio(Integer.parseInt(objetoNegocioJSon.get("id").toString()), objetoNegocioJSon.get("Nombre").toString(),objetoNegocioJSon.get("Descripcion").toString());
                                negocios.add(negocio);
                                System.out.println(negocio.toString());
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("DATA", new Peticion("obtener_todos_negocios",null).getJSON());
                return params;
            }
        };
        queue.add(jsonObjectRequest);*/
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            System.out.println(response);
            try {
                JSONObject resp = new JSONObject(response);
                if ((resp.getBoolean("error")) == true) {
                    throw new VolleyError(resp.getString("datos"));
                } else {
                    JSONArray arrayDeJson = resp.getJSONArray("datos");

                    for (int i = 0; i < arrayDeJson.length(); i++){
                        JSONObject objetoNegocioJSon = arrayDeJson.getJSONObject(i);
                        Negocio negocio = new Negocio();
                        negocio.setId_negocio(Integer.parseInt(objetoNegocioJSon.get("id").toString()));
                        negocio.setNombre(objetoNegocioJSon.get("Nombre").toString());
                        negocio.setDescripcion(objetoNegocioJSon.get("Descripcion").toString());
                        negocios.add(negocio);
                    }

                    adaptorNegocio= new RecyclerViewAdaptorNegocio(negocios,usuario);
                    recyclerViewNegocio.setAdapter(adaptorNegocio);
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(PantallaDeNegocios.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                //finish();
            }
        }, this::onErrorResponse) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("DATA", new Peticion("obtener_todos_negocios", null).getJSON());
                return params;
            }
        };
        queue.add(request);
    }

    private void onErrorResponse(VolleyError error) {
        Toast.makeText(PantallaDeNegocios.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show();
        finish();
    }
}