package com.proyecto.fasttohome.vista.pedido;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Categoria;
import com.proyecto.fasttohome.modelo.Direccion;
import com.proyecto.fasttohome.modelo.Negocio;
import com.proyecto.fasttohome.modelo.Pedido;
import com.proyecto.fasttohome.modelo.Peticion;
import com.proyecto.fasttohome.modelo.Usuario;
import com.proyecto.fasttohome.vista.PantallaPrincipal;
import com.proyecto.fasttohome.vista.pedido.recycler_adaptors.RecyclerViewAdaptorNegocio;
import com.squareup.picasso.Picasso;

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
    private Pedido pedido;
    private Direccion direccion;
    private HashMap<Integer, Categoria> categorias;
    private List<Negocio> negocios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_de_negocios);
        //RECEPCION DEL ACTIVITY ANTERIOR
        usuario = (Usuario) getIntent().getExtras().getSerializable("user");
        direccion = (Direccion) getIntent().getExtras().getSerializable("direccion");
        pedido = (Pedido) getIntent().getExtras().getSerializable("pedido");

        recyclerViewNegocio = (RecyclerView) findViewById(R.id.recyclerNegocios);
        recyclerViewNegocio.setLayoutManager(new LinearLayoutManager(this));

        obtenerNegocios();
    }

    public void obtenerNegocios() {
        negocios = new ArrayList<Negocio>();
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
                    for (int i = 0; i < arrayDeJson.length(); i++) {
                        JSONObject objetoNegocioJSon = arrayDeJson.getJSONObject(i);
                        Negocio negocio = new Negocio();
                        negocio.setId_negocio(objetoNegocioJSon.getInt("id"));
                        negocio.setNombre(objetoNegocioJSon.get("Nombre").toString());
                        negocio.setDescripcion(objetoNegocioJSon.get("Descripcion").toString());
                        negocio.setId_categoria(objetoNegocioJSon.getInt("id_categoria"));
                        negocio.setId_direccion(objetoNegocioJSon.getInt("direccion_id"));
                        try{
                            String imgUrl = getString(R.string.imgUrl) + objetoNegocioJSon.getString("url");
                            negocio.setUrl_imagen(imgUrl);
                        }catch (Exception e){
                        }
                        negocios.add(negocio);
                    }
                    obtenerCategoriasNegocios();
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


    public void obtenerCategoriasNegocios() {
        categorias = new HashMap<>();
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
                    for (int i = 0; i < arrayDeJson.length(); i++) {
                        JSONObject job = arrayDeJson.getJSONObject(i);
                        System.out.println(job.getString("Nombre"));
                        categorias.put(job.getInt("id"),new Categoria(job.getInt("id"),job.getString("Nombre")));
                    }

                    rellenarRecyclerView();
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(PantallaDeNegocios.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                finish();
            }
        }, this::onErrorResponse) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("DATA", new Peticion("obtener_categorias", null).getJSON());
                return params;
            }
        };
        queue.add(request);
    }

    private void rellenarRecyclerView() {
        adaptorNegocio = new RecyclerViewAdaptorNegocio(negocios, usuario,pedido,categorias);
        recyclerViewNegocio.setAdapter(adaptorNegocio);
    }

    private void onErrorResponse(VolleyError error) {
        Toast.makeText(PantallaDeNegocios.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show();
        irPrincipal();
    }

    public void onBackPressed() {
        irPrincipal();
    }

    public void irPrincipal() {
        Intent i = new Intent(this, PantallaPrincipal.class );
        i.putExtra("user", usuario);
        startActivity(i);
    };
}