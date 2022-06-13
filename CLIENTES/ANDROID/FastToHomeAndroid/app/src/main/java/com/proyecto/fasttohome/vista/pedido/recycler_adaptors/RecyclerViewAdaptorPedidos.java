package com.proyecto.fasttohome.vista.pedido.recycler_adaptors;

import static com.proyecto.fasttohome.util.Texto.leftPad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Negocio;
import com.proyecto.fasttohome.modelo.Pedido;
import com.proyecto.fasttohome.modelo.Peticion;
import com.proyecto.fasttohome.modelo.Producto;
import com.proyecto.fasttohome.modelo.Usuario;
import com.proyecto.fasttohome.vista.pedido.PantallaDePedidos;
import com.proyecto.fasttohome.vista.pedido.SeleccionarProductos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerViewAdaptorPedidos extends RecyclerView.Adapter<RecyclerViewAdaptorPedidos.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView fechaPedido, numeroPedido,estadoPedido;
        private ImageView image;
        private Usuario usuario;
        private Pedido pedido;
        private Button pedir, info;
        private Context contexto;
        private ListView listaProductos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fechaPedido = itemView.findViewById(R.id.fechaPedido);
            numeroPedido = itemView.findViewById(R.id.numeroPedido);
            estadoPedido = itemView.findViewById(R.id.estadoPedido);
            listaProductos = itemView.findViewById(R.id.cestaPedido);
            contexto = itemView.getContext();
        }
    }

    private List<Pedido> listaPedidos;
    private HashMap<Integer, Producto> productos;
    private Usuario usuario;
    public RecyclerViewAdaptorPedidos(List<Pedido> listaPedidos, Usuario usuario) {
        this.listaPedidos = listaPedidos;
        this.usuario = usuario;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pedido, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pedido pedidoActual = listaPedidos.get(position);

        holder.usuario = usuario;
        holder.pedido = pedidoActual;
        holder.numeroPedido.setText(pedidoActual.getId_pedido());
        holder.fechaPedido.setText(pedidoActual.getFecha_hora());
        holder.estadoPedido.setText(pedidoActual.getEstado());
        obtenerProductosNegocio(holder.contexto, pedidoActual,holder);


        /*
        holder.nombre.setText(negocioActual.getNombre());
        holder.categoria.setText(categorias.get(negocioActual.getId_categoria()).getNombre());

        Picasso.get().load(negocioActual.getUrl_imagen()).into(holder.image);
        holder.info.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(holder.contexto);
            builder.setTitle("INFORMACIÓN DEL NEGOCIO");
            builder.setMessage(negocioActual.getDescripcion()).show();
        });
        holder.pedir.setOnClickListener(view -> {
            pedido.setId_negocio(negocioActual.getId_negocio());
            Intent intent = new Intent(holder.contexto, SeleccionarProductos.class);
            intent.putExtra("user", usuario);
            intent.putExtra("negocio", negocioActual);
            intent.putExtra("pedido", pedido);
            holder.contexto.startActivity(intent);
        });*/
    }


    public void obtenerCestaPedido(Context contexto, Pedido pedido, ViewHolder holder) {
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        String url = contexto.getString(R.string.apiUrl);
        RequestQueue queue = Volley.newRequestQueue(contexto);
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

                    }
                    ArrayList<String> lista = new ArrayList<>();
                    for (Producto : listaProductos) {
                        Producto producto = productos.get(entry.getKey());
                        precioTotal = precioTotal + (producto.getPrecio() * entry.getValue());
                        lista.add(leftPad("€" + producto.getPrecio(), 5) + leftPad("  Uds: " + entry.getValue(), 12) + "  " + producto.getNombre());
                        indice++;
                    }
                    total.setText(String.valueOf(precioTotal + " Euros"));
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
                    holder.listaProductos.setAdapter(adapter);
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(contexto, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, volleyError -> {
            Toast.makeText(contexto, "ERROR DE CONEXIÓN = " + volleyError, Toast.LENGTH_SHORT).show();
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("DATA", new Peticion("contenido_cesta_pedido", pedido.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }

    public void obtenerProductosNegocio(Context contexto, Pedido pedido, ViewHolder holder) {
        productos = new HashMap<>();
        String url = contexto.getString(R.string.apiUrl);;
        RequestQueue queue = Volley.newRequestQueue(contexto);
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
                        productos.put(producto.getId_producto(), producto);
                    }

                    adaptorProducto = new RecyclerViewAdaptorProducto(productos, productosSeleccionados,pedir);
                    recyclerViewProducto.setAdapter(adaptorProducto);
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(contexto, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, error -> {
            Toast.makeText(contexto, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show();
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                Negocio negocio = new Negocio();
                negocio.setId_negocio(pedido.getId_negocio());
                params.put("DATA", new Peticion("obtener_productos_negocio", negocio.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }

    @Override
    public int getItemCount() {
        return listaPedidos.size();
    }
}
