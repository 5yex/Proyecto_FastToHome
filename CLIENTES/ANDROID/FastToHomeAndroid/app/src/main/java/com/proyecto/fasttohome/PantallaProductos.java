package com.proyecto.fasttohome;

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
import com.proyecto.fasttohome.modelo.Peticion;
import com.proyecto.fasttohome.modelo.Producto;
import com.proyecto.fasttohome.recycler_adaptors.RecyclerViewAdaptorProducto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PantallaProductos extends AppCompatActivity {

    private RecyclerView recyclerViewProducto;
    private RecyclerViewAdaptorProducto adaptorProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_productos);

        recyclerViewProducto = (RecyclerView) findViewById(R.id.recyclerProductos);
        recyclerViewProducto.setLayoutManager(new LinearLayoutManager(this));


    }

    public void obtenerProductosNegocio() {

        List<Producto> productos = new ArrayList<>();

        String url = "http://10.0.2.2/php/webService/api.php";
        RequestQueue queue = Volley.newRequestQueue(PantallaProductos.this);
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
                        productos.add(producto);
                    }

                    adaptorProducto = new RecyclerViewAdaptorProducto(productos);
                    recyclerViewProducto.setAdapter(adaptorProducto);
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(PantallaProductos.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                //finish();
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
        Toast.makeText(PantallaProductos.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show();
        finish();
    }
}