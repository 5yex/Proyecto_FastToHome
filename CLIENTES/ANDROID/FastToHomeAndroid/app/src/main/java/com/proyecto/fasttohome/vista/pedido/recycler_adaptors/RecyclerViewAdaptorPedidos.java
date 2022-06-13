package com.proyecto.fasttohome.vista.pedido.recycler_adaptors;

import static com.proyecto.fasttohome.util.Texto.leftPad;

import android.content.Context;
import android.content.Intent;
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
import com.proyecto.fasttohome.modelo.Cesta;
import com.proyecto.fasttohome.modelo.Negocio;
import com.proyecto.fasttohome.modelo.Pedido;
import com.proyecto.fasttohome.modelo.Peticion;
import com.proyecto.fasttohome.modelo.Producto;
import com.proyecto.fasttohome.modelo.Usuario;
import com.proyecto.fasttohome.vista.PantallaPrincipal;
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
        private Usuario usuario;
        private Pedido pedido;
        private Context contexto;
        private ListView listaProductos;
        private Button marcarRecibido;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fechaPedido = itemView.findViewById(R.id.fechaPedido);
            numeroPedido = itemView.findViewById(R.id.numeroPedido);
            estadoPedido = itemView.findViewById(R.id.estadoPedido);
            listaProductos = itemView.findViewById(R.id.cestaPedido);
            contexto = itemView.getContext();
            marcarRecibido = itemView.findViewById(R.id.marcarRecibidoPedido);
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
        obtenerCestaPedido(holder.contexto, pedidoActual,holder);
        holder.marcarRecibido.setOnClickListener(view -> {
            setPedidoRecibido(holder.contexto, pedidoActual,holder);
        });
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
    public void setPedidoRecibido(Context contexto, Pedido pedido, ViewHolder holder) {
        String url = contexto.getString(R.string.apiUrl);
        RequestQueue queue = Volley.newRequestQueue(contexto);
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            System.out.println(response);
            try {
                JSONObject resp = new JSONObject(response);
                if ((resp.getBoolean("error")) == true) {
                    throw new VolleyError(resp.getString("datos"));
                } else {
                    Intent i = new Intent(contexto, PantallaPrincipal.class);
                    i.putExtra("user", usuario);
                    contexto.startActivity(i);
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
                params.put("DATA", new Peticion("actualizar_estado_pedido", pedido.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }

    public void obtenerCestaPedido(Context contexto, Pedido pedido, ViewHolder holder) {
        ArrayList<Cesta> listaProductosCesta = new ArrayList<>();
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
                        JSONObject obj = arrayDeJson.getJSONObject(i);
                        Cesta product = new Cesta();
                        product.setId_cesta(obj.getInt("id"));
                        product.setId_pedido(obj.getInt("id_pedido "));
                        product.setId_producto(obj.getInt("id_producto "));
                        product.setCantidad(obj.getInt("Cantidad"));
                    }
                    ArrayList<String> lista = new ArrayList<>();
                    for (Cesta product: listaProductosCesta) {
                        Producto producto = productos.get(product.getId_producto());
                        int cantidad = product.getCantidad();
                        double precioTot = producto.getPrecio() * cantidad;
                        lista.add(leftPad("€" + producto.getPrecio(), 5)  +"Tot: " +leftPad("€" + precioTot, 5)  +leftPad("  Uds: " + cantidad, 12) + "  " + producto.getNombre());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(contexto, android.R.layout.simple_list_item_1, lista);
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
