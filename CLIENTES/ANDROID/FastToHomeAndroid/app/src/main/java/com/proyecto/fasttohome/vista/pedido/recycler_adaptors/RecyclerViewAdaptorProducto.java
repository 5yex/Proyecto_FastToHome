package com.proyecto.fasttohome.vista.pedido.recycler_adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Producto;

import java.util.List;

public class RecyclerViewAdaptorProducto extends RecyclerView.Adapter<RecyclerViewAdaptorProducto.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre, descripcion, precio;
        private Button buy;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.tvNombreProducto);
            descripcion = (TextView) itemView.findViewById(R.id.tvDescripcionProducto);
            precio = (TextView) itemView.findViewById(R.id.tvPrecioProducto);
            buy = (Button) itemView.findViewById(R.id.buy);
        }
    }

    public List<Producto> listaProductos;

    public RecyclerViewAdaptorProducto(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(listaProductos.get(position).getNombre());
        holder.descripcion.setText(listaProductos.get(position).getDescripcion());
        holder.precio.setText("Precio: " + listaProductos.get(position).getPrecio() + "€");
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }
}
