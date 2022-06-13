package com.proyecto.fasttohome.vista.pedido;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Categoria;
import com.proyecto.fasttohome.modelo.Cesta;
import com.proyecto.fasttohome.modelo.Negocio;
import com.proyecto.fasttohome.modelo.Pedido;
import com.proyecto.fasttohome.modelo.Peticion;
import com.proyecto.fasttohome.modelo.Usuario;
import com.proyecto.fasttohome.vista.PantallaPrincipal;
import com.proyecto.fasttohome.vista.pedido.recycler_adaptors.RecyclerViewAdaptorPedidos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PantallaDePedidos extends AppCompatActivity {

    private RecyclerView recyclerViewPedidos;
    private RecyclerViewAdaptorPedidos adaptorNegocio;
    private Usuario usuario;
    private List<Pedido> listaPedidos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_de_pedidos);
        //RECEPCION DEL ACTIVITY ANTERIOR
        usuario = (Usuario) getIntent().getExtras().getSerializable("user");

        recyclerViewPedidos = (RecyclerView) findViewById(R.id.recyclerPedidos);
        recyclerViewPedidos.setLayoutManager(new LinearLayoutManager(this));

        obtenerPedidos();
    }

    public void obtenerPedidos() {
        listaPedidos = new ArrayList<Pedido>();
        String url = getString(R.string.apiUrl);
        RequestQueue queue = Volley.newRequestQueue(PantallaDePedidos.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            System.out.println(response);
            try {
                JSONObject resp = new JSONObject(response);
                if ((resp.getBoolean("error")) == true) {
                    throw new VolleyError(resp.getString("datos"));
                } else {
                    JSONArray arrayDeJson = resp.getJSONArray("datos");
                    for (int i = 0; i < arrayDeJson.length(); i++) {
                        JSONObject objPedidos = arrayDeJson.getJSONObject(i);
                        Pedido pedido = new Pedido();
                        pedido.setEstado(objPedidos.getString("estado"));
                        pedido.setId_pedido(objPedidos.getInt("id"));
                        pedido.setTotal(objPedidos.getDouble("total"));
                        pedido.setTransporte(objPedidos.getString("transporte"));
                        pedido.setFecha_hora(objPedidos.getString("fecha_hora"));
                        pedido.setId_negocio(objPedidos.getInt("id_negocio"));
                        listaPedidos.add(pedido);
                    }
                    rellenarRecyclerView();
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(PantallaDePedidos.this, "No hay ningún pedido", Toast.LENGTH_SHORT).show();
            }
        }, this::onErrorResponse) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("DATA", new Peticion("obtener_pedidos_cliente", usuario.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }

    private void rellenarRecyclerView() {
        adaptorNegocio = new RecyclerViewAdaptorPedidos(listaPedidos, usuario);
        recyclerViewPedidos.setAdapter(adaptorNegocio);
    }

    private void onErrorResponse(VolleyError error) {
        Toast.makeText(PantallaDePedidos.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show();
        irPrincipal();
    }

    @Override
    public void onBackPressed() {
        irPrincipal();
    }

    public void irPrincipal() {
        Intent i = new Intent(this, PantallaPrincipal.class);
        i.putExtra("user", usuario);
        startActivity(i);
    }

    ;
}