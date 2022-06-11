package com.proyecto.fasttohome.vista.pedido;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.databinding.ActivitySeleccionarProductosBinding;
import com.proyecto.fasttohome.modelo.Cesta;
import com.proyecto.fasttohome.modelo.Negocio;
import com.proyecto.fasttohome.modelo.Peticion;
import com.proyecto.fasttohome.modelo.Producto;
import com.proyecto.fasttohome.modelo.Usuario;
import com.proyecto.fasttohome.vista.pedido.recycler_adaptors.RecyclerViewAdaptorProducto;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeleccionarProductos extends AppCompatActivity {

    private ActivitySeleccionarProductosBinding binding;
    private HashMap<Integer, Integer> productosSeleccionados;
    private RecyclerView recyclerViewProducto;
    private RecyclerViewAdaptorProducto adaptorProducto;
    private Usuario usuario;
    private ImageView imagenNegocio;
    private Negocio negocio;
    private Button pedir;
    private HashMap<Integer, Producto> productos;
    private CoordinatorLayout pantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySeleccionarProductosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        usuario = (Usuario) getIntent().getExtras().getSerializable("user");
        negocio = (Negocio) getIntent().getExtras().getSerializable("negocio");
        imagenNegocio = findViewById(R.id.imgNegocioS);
        toolBarLayout.setTitle(negocio.getNombre());
        Picasso.get().load(negocio.getUrl_imagen()).into(imagenNegocio);
        FloatingActionButton fab = binding.fab;

        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .show());

        productosSeleccionados = new HashMap<Integer, Integer>();
        recyclerViewProducto = (RecyclerView) findViewById(R.id.recyclerProductos);
        recyclerViewProducto.setLayoutManager(new LinearLayoutManager(this));
        pantalla = (CoordinatorLayout)  findViewById(R.id.constraint);
        pedir = (Button) findViewById(R.id.doPedido);


        obtenerProductosNegocio();
    }

    public void obtenerProductosNegocio() {
        productos = new HashMap<>();
        String url = getString(R.string.apiUrl);;
        RequestQueue queue = Volley.newRequestQueue(SeleccionarProductos.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            System.out.println(response);
            try {
                JSONObject resp = new JSONObject(response);
                if ((resp.getBoolean("error")) == true) {
                    throw new VolleyError(resp.getString("datos"));
                } else {
                    JSONArray arrayDeJson = resp.getJSONArray("datos");
                    for (int i = 0; i < arrayDeJson.length(); i++) {
                        JSONObject objetoProductoJSon = arrayDeJson.getJSONObject(i);
                        Producto producto = new Producto();
                        producto.setId_producto(Integer.parseInt(objetoProductoJSon.get("id").toString()));
                        producto.setNombre(objetoProductoJSon.get("Nombre").toString());
                        producto.setDescripcion(objetoProductoJSon.get("Descripcion").toString());
                        producto.setPrecio(Double.parseDouble(objetoProductoJSon.get("Precio").toString()));
                        try{
                            String imgUrl = getString(R.string.imgUrl) + objetoProductoJSon.getString("url");
                            producto.setUrl_imagen(imgUrl);
                        }catch (Exception e){
                        }
                        productos.put(producto.getId_producto(), producto);
                    }

                    adaptorProducto = new RecyclerViewAdaptorProducto(productos, productosSeleccionados);
                    recyclerViewProducto.setAdapter(adaptorProducto);

                    binding.doPedido.setOnClickListener(view -> {
                        double precioTotal = 0;
                        for(Map.Entry<Integer, Integer> entry : productosSeleccionados.entrySet()) {
                            precioTotal = precioTotal + (productos.get(entry.getKey()).getPrecio() * entry.getValue());
                        }
                        binding.doPedido.setText("Productos: " + productosSeleccionados.size() + " Precio: " + precioTotal +" - HACER PEDIDO");
                    });

                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(SeleccionarProductos.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                finish();
            }
        }, this::onErrorResponse) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("DATA", new Peticion("obtener_productos_negocio", negocio.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }

    private void onErrorResponse(VolleyError error) {
        Toast.makeText(SeleccionarProductos.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onBackPressed() {
            AlertDialog.Builder builder = new AlertDialog.Builder(SeleccionarProductos.this);
            builder.setTitle("ATENCIÓN").setMessage("Si vuelves atrás cancelaras el pedido.\n ¿Seguro que quieres salir?");
            builder.setNegativeButton("Volver a mi pedido",null);
            builder.setPositiveButton("Sí", (dialogInterface, i) -> {
                super.onBackPressed();
            }).show();
    }
}