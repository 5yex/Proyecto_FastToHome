package com.proyecto.fasttohome.vista.pedido.recycler_adaptors;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Categoria;
import com.proyecto.fasttohome.modelo.Cesta;
import com.proyecto.fasttohome.modelo.Negocio;
import com.proyecto.fasttohome.modelo.Pedido;
import com.proyecto.fasttohome.modelo.Usuario;
import com.proyecto.fasttohome.vista.pedido.SeleccionarProductos;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

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
    private HashMap<Integer, Cesta> productos;
    private Usuario usuario;
    private Pedido pedido;
    public RecyclerViewAdaptorPedidos(List<Pedido> listaPedidos, Usuario usuario, Pedido pedido, HashMap<Integer, Cesta> productos) {
        this.listaPedidos = listaPedidos;
        this.usuario = usuario;
        this.pedido = pedido;
        this.productos= productos;
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

    @Override
    public int getItemCount() {
        return listaNegocios.size();
    }
}
