package com.proyecto.fasttohome.vista.pedido.recycler_adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Cesta;
import com.proyecto.fasttohome.modelo.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecyclerViewAdaptorProducto extends RecyclerView.Adapter<RecyclerViewAdaptorProducto.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre, descripcion, precio;
        private Button ADD,DEL;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.tvNombreProducto);
            descripcion = (TextView) itemView.findViewById(R.id.tvDescripcionProducto);
            precio = (TextView) itemView.findViewById(R.id.tvPrecioProducto);
            ADD = (Button) itemView.findViewById(R.id.ADD);
            DEL = (Button) itemView.findViewById(R.id.DEL);
        }
    }

    public List<Producto> listaProductos;
    //El key (int) será un id de producto para localizarlo mejor
    public HashMap<Integer,Integer> productosSeleccionados;

    public RecyclerViewAdaptorProducto(List<Producto> listaProductos,HashMap<Integer,Integer> productosSeleccionados) {
        this.listaProductos = listaProductos;
        this.productosSeleccionados = productosSeleccionados;
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

        holder.ADD.setOnClickListener(view -> {
            int productoActual = listaProductos.get(position).getId_producto();
            if(!productosSeleccionados.containsKey(productoActual)){
                productosSeleccionados.put(productoActual,1);
            }else{
                int oldValue = productosSeleccionados.get(productoActual);
                productosSeleccionados.put(productoActual,oldValue+1);
            };
        });
        holder.DEL.setOnClickListener(view -> {
            int productoActual = listaProductos.get(position).getId_producto();
            if(productosSeleccionados.containsKey(productoActual)){
                int oldValue = productosSeleccionados.get(productoActual);
                if(oldValue == 1 | oldValue > 0 ){
                    productosSeleccionados.remove(productoActual);
                }else{
                    productosSeleccionados.put(productoActual,oldValue-1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }
}
