package com.proyecto.fasttohome.vista.pedido;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.databinding.ActivitySeleccionarProductosBinding;
import com.proyecto.fasttohome.modelo.Direccion;
import com.proyecto.fasttohome.modelo.Negocio;
import com.proyecto.fasttohome.modelo.Pedido;
import com.proyecto.fasttohome.modelo.Peticion;
import com.proyecto.fasttohome.modelo.Producto;
import com.proyecto.fasttohome.modelo.Usuario;
import com.proyecto.fasttohome.vista.PantallaPrincipal;
import com.proyecto.fasttohome.vista.pedido.recycler_adaptors.RecyclerViewAdaptorProducto;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa a la pantalla de selección de productos
 */
public class SeleccionarProductos extends AppCompatActivity {

    private ActivitySeleccionarProductosBinding binding;
    private HashMap<Integer, Integer> productosSeleccionados;
    private HashMap<Integer, Producto> productos;
    private Usuario usuario;
    private Negocio negocio;
    private Pedido pedido;
    private RecyclerView recyclerViewProducto;
    private RecyclerViewAdaptorProducto adaptorProducto;
    private Button pedir;
    private Direccion direccion;
    private ImageView imagenNegocio;
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
        pedido = (Pedido) getIntent().getExtras().getSerializable("pedido");
        imagenNegocio = findViewById(R.id.imgNegocioS);
        toolBarLayout.setTitle(negocio.getNombre());
        Picasso.get().load(negocio.getUrl_imagen()).into(imagenNegocio);
        FloatingActionButton fab = binding.fab;

        fab.setOnClickListener(view -> {
            if(!direccion.getCoordenadas().isEmpty() && direccion.getCoordenadas().length() > 5){
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q="+direccion.getCoordenadas()+"&ll="+direccion.getCoordenadas()+"&z=20z"));
                startActivity(browserIntent);
            }else{
                Toast.makeText(this, "Este negocio no ha configurado su ubicación", Toast.LENGTH_SHORT).show();
            }
        });

        productosSeleccionados = new HashMap<Integer, Integer>();
        recyclerViewProducto = (RecyclerView) findViewById(R.id.recyclerProductos);
        recyclerViewProducto.setLayoutManager(new LinearLayoutManager(this));
        pantalla = (CoordinatorLayout)  findViewById(R.id.constraint);
        pedir = (Button) findViewById(R.id.doPedido);
        pedir.setOnClickListener(view -> {
            if(productosSeleccionados.size()>0) {
                    irFinalizar();
            }else {
                Toast.makeText(this, "Tienes que seleccionar productos", Toast.LENGTH_SHORT).show();
            }
        });
        obtenerProductosNegocio();
        obtenerDireccionNegocio();
    }

    public void irFinalizar() {
        Intent i = new Intent(this, FinalizarPedido.class );
        i.putExtra("productosSeleccionados",productosSeleccionados);
        i.putExtra("productos",productos);
        i.putExtra("usuario", usuario);
        i.putExtra("negocio", negocio);
        i.putExtra("pedido",pedido);
        startActivity(i);
    };

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
                            String imgUrl = getString(R.string.serverUrl) + objetoProductoJSon.getString("url");
                            producto.setUrl_imagen(imgUrl);
                        }catch (Exception e){
                        }
                        productos.put(producto.getId_producto(), producto);
                    }

                    adaptorProducto = new RecyclerViewAdaptorProducto(productos, productosSeleccionados,pedir);
                    recyclerViewProducto.setAdapter(adaptorProducto);
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(SeleccionarProductos.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                finish();
            }
        }, error -> {
            Toast.makeText(SeleccionarProductos.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show();
            finish();
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("DATA", new Peticion("obtener_productos_negocio", negocio.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }

    public void obtenerDireccionNegocio() {
        RequestQueue queue = Volley.newRequestQueue(SeleccionarProductos.this);
        String url = getString(R.string.apiUrl);
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            System.out.println(response);
            try {
                JSONObject resp = new JSONObject(response);
                if ((resp.getBoolean("error")) == true) {
                    throw new VolleyError(resp.getString("datos"));
                } else {
                    JSONObject datos = resp.getJSONArray("datos").getJSONObject(0);
                    direccion = new Direccion();
                    direccion.setCalle(datos.getString("Calle"));
                    direccion.setNumero(datos.getInt("Numero"));
                    direccion.setCiudad(datos.getString("Ciudad"));
                    direccion.setCodigo_postal(datos.getInt("CP"));
                    direccion.setOtros(datos.getString("Otros"));
                    direccion.setCoordenadas(datos.getString("Coordenadas"));
                    direccion.setId_direccion(datos.getInt("id"));
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(SeleccionarProductos.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
                finish();
            }
        }, error -> {
            Toast.makeText(SeleccionarProductos.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show();
            finish();
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("DATA", new Peticion("obtener_direccion", negocio.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }

    @Override
    public void onBackPressed() {
            AlertDialog.Builder builder = new AlertDialog.Builder(SeleccionarProductos.this);
            builder.setTitle("ATENCIÓN").setMessage("Si vuelves atrás cancelaras el pedido.\n ¿Seguro que quieres salir?");
            builder.setNegativeButton("VOLVER A MI PEDIDO",null);
            builder.setPositiveButton("SALIR DEL PEDIDO", (dialogInterface, i) -> {
                irPrincipal();
            }).show();
    }
    public void irPrincipal() {
        Intent i = new Intent(this, PantallaPrincipal.class );
        i.putExtra("user", usuario);
        startActivity(i);
    };
}