package com.proyecto.fasttohome.vista.pedido.recycler_adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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
import com.proyecto.fasttohome.modelo.Usuario;
import com.proyecto.fasttohome.vista.pedido.PantallaDePedidos;

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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fechaPedido = itemView.findViewById(R.id.fechaPedido);
            numeroPedido = itemView.findViewById(R.id.numeroPedido);
            estadoPedido = itemView.findViewById(R.id.estadoPedido);
            contexto = itemView.getContext();
        }
    }

    private List<Pedido> listaPedidos;
    private Usuario usuario;
    private Pedido pedido;
    public RecyclerViewAdaptorPedidos(List<Pedido> listaPedidos, Usuario usuario, Pedido pedido) {
        this.listaPedidos = listaPedidos;
        this.usuario = usuario;
        this.pedido = pedido;
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

    public void obtenerProductosNegocio(Context contexto, Pedido pedido) {
        listaPedidos = new ArrayList<Pedido>();
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

    @Override
    public int getItemCount() {
        return listaPedidos.size();
    }
}
