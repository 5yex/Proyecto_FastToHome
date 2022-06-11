package com.proyecto.fasttohome.vista.pedido.recycler_adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Producto;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

public class RecyclerViewAdaptorProducto extends RecyclerView.Adapter<RecyclerViewAdaptorProducto.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre, descripcion, precio, cantidadActual;
        private Button ADD, DEL;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.tvNombreProducto);
            descripcion = (TextView) itemView.findViewById(R.id.tvDescripcionProducto);
            precio = (TextView) itemView.findViewById(R.id.tvPrecioProducto);
            cantidadActual = (TextView) itemView.findViewById(R.id.CantidadProducto);
            ADD = (Button) itemView.findViewById(R.id.ADD);
            DEL = (Button) itemView.findViewById(R.id.DEL);
            image = (ImageView) itemView.findViewById(R.id.imageProducto);
        }
    }

    public List<Producto> listaProductos;
    //El key (int) será un id de producto para localizarlo mejor
    public HashMap<Integer, Integer> productosSeleccionados;

    public RecyclerViewAdaptorProducto(List<Producto> listaProductos, HashMap<Integer, Integer> productosSeleccionados) {
        this.listaProductos = listaProductos;
        this.productosSeleccionados = productosSeleccionados;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Producto productoActual = listaProductos.get(position);
        int productoActualId = productoActual.getId_producto();
        holder.nombre.setText(productoActual.getNombre());
        holder.descripcion.setText(productoActual.getDescripcion());
        holder.precio.setText("Precio: " + productoActual.getPrecio() + "€");
        Picasso.get().setLoggingEnabled(true);
        Picasso.get().load(productoActual.getUrl_imagen()).into(holder.image);
        View.OnClickListener listener = view -> {
            if(holder.DEL.getId() == view.getId()){
                if (productosSeleccionados.containsKey(productoActualId)) {
                    int oldValue = productosSeleccionados.get(productoActualId);
                    if (oldValue < 2) {
                        productosSeleccionados.remove(productoActualId);
                        holder.DEL.setEnabled(false);
                    } else {
                        productosSeleccionados.put(productoActualId, oldValue - 1);
                    }
                }
            }
            if(holder.ADD.getId() == view.getId()){
                if (!productosSeleccionados.containsKey(productoActualId)) {
                    productosSeleccionados.put(productoActualId, 1);
                } else {
                    int oldValue = productosSeleccionados.get(productoActualId);
                    productosSeleccionados.put(productoActualId, oldValue + 1);
                }
                holder.DEL.setEnabled(true);
            }
            updateContador(holder, productoActualId);
        };

       holder.DEL.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                productosSeleccionados.remove(productoActualId);
                holder.DEL.setEnabled(false);
                updateContador(holder, productoActualId);
                Snackbar.make(v, "Has quitado: "+ holder.nombre.getText(), Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                return true;
            }
        });
        holder.ADD.setOnClickListener(listener);
        holder.DEL.setOnClickListener(listener);

    }

    private void updateContador(@NonNull ViewHolder holder, int productoActual) {
        if(productosSeleccionados.containsKey(productoActual)){
            holder.cantidadActual.setText("Te llevas: "+ productosSeleccionados.get(productoActual));
        }else{
            holder.cantidadActual.setText("No te llevas ninguno");
        }
    }

    public HashMap<Integer, Integer> getProductosSeleccionados() {
        return productosSeleccionados;
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }
}
