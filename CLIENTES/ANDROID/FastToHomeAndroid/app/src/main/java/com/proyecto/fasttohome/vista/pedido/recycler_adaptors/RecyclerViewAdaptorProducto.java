package com.proyecto.fasttohome.vista.pedido.recycler_adaptors;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Producto;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerViewAdaptorProducto extends RecyclerView.Adapter<RecyclerViewAdaptorProducto.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre, precio, cantidadActual;
        private Button add, eliminar, info,pedir;
        private ImageView image;
        private Context contexto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contexto = itemView.getContext();
            nombre = (TextView) itemView.findViewById(R.id.tvNombreProducto);
            precio = (TextView) itemView.findViewById(R.id.tvPrecioProducto);
            cantidadActual = (TextView) itemView.findViewById(R.id.CantidadProducto);
            add = (Button) itemView.findViewById(R.id.ADD);
            eliminar = (Button) itemView.findViewById(R.id.DEL);
            info = (Button) itemView.findViewById(R.id.info);
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
        // holder.descripcion.setText(productoActual.getDescripcion());
        holder.precio.setText(productoActual.getPrecio() + "€");
        Picasso.get().setLoggingEnabled(true);
        Picasso.get().load(productoActual.getUrl_imagen()).into(holder.image);
        View.OnClickListener listener = view -> {
            if (holder.eliminar.getId() == view.getId()) {
                if (productosSeleccionados.containsKey(productoActualId)) {
                    int oldValue = productosSeleccionados.get(productoActualId);
                    if (oldValue < 2) {
                        productosSeleccionados.remove(productoActualId);
                        holder.eliminar.setEnabled(false);
                    } else {
                        productosSeleccionados.put(productoActualId, oldValue - 1);
                    }
                }
            }
            if (holder.add.getId() == view.getId()) {
                if (!productosSeleccionados.containsKey(productoActualId)) {
                    productosSeleccionados.put(productoActualId, 1);
                } else {
                    int oldValue = productosSeleccionados.get(productoActualId);
                    productosSeleccionados.put(productoActualId, oldValue + 1);
                }
                holder.eliminar.setEnabled(true);
            }
            updateContador(holder, productoActualId);
        };

        holder.eliminar.setOnLongClickListener(v -> {
            productosSeleccionados.remove(productoActualId);
            holder.eliminar.setEnabled(false);
            updateContador(holder, productoActualId);
            return true;
        });

        holder.add.setOnClickListener(listener);
        holder.eliminar.setOnClickListener(listener);

        holder.info.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(holder.contexto);
        builder.setTitle("INFORMACIÓN DEL PRODUCTO").setMessage(productoActual.getDescripcion()).show();
        });
    }

    private void updateContador(@NonNull ViewHolder holder, int productoActual) {
        if (productosSeleccionados.containsKey(productoActual)) {
            holder.cantidadActual.setText("Te llevas: " + productosSeleccionados.get(productoActual));
        } else {
            holder.cantidadActual.setText("No llevas ninguno");
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
