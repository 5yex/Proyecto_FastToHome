package com.proyecto.fasttohome.vista.pedido;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Negocio;
import com.proyecto.fasttohome.modelo.Peticion;
import com.proyecto.fasttohome.modelo.Usuario;
import com.proyecto.fasttohome.vista.pedido.recycler_adaptors.RecyclerViewAdaptorNegocio;

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
        usuario = (Usuario) getIntent().getExtras().getSerializable("user");

        recyclerViewNegocio=(RecyclerView) findViewById(R.id.recyclerNegocios);
        recyclerViewNegocio.setLayoutManager(new LinearLayoutManager(this));

        obtenerNegocios();
    }

    public void obtenerNegocios(){
        List<Negocio> negocios = new ArrayList<Negocio>();

        String url = getString(R.string.apiUrl);
        RequestQueue queue = Volley.newRequestQueue(PantallaDeNegocios.this);
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
                        if(objetoNegocioJSon.get("imagenes_id") != null) {
                            negocio.setId_img(objetoNegocioJSon.getInt("imagenes_id"));
                        }
                        negocios.add(negocio);
                    }

                    adaptorNegocio= new RecyclerViewAdaptorNegocio(negocios,usuario);
                    recyclerViewNegocio.setAdapter(adaptorNegocio);
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(PantallaDeNegocios.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                finish();
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

    public void imagen(RequestQueue queue, int id_imagen){
        List<Negocio> negocios = new ArrayList<Negocio>();
        String url = getString(R.string.apiUrl);
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
                        if(objetoNegocioJSon.get("url") != null) {
                            String url =
                        }
                        negocios.add(negocio);
                    }

                    adaptorNegocio= new RecyclerViewAdaptorNegocio(negocios,usuario);
                    recyclerViewNegocio.setAdapter(adaptorNegocio);
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(PantallaDeNegocios.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
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