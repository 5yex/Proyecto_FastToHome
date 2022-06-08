package com.proyecto.fasttohome.recycler_adaptors;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.fasttohome.R;

public class RecyclerViewAdaptorProducto extends RecyclerView.Adapter<RecyclerViewAdaptorProducto.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre, descripcion, precio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.tvNombreProducto);
            descripcion = (TextView) itemView.findViewById(R.id.tvDescripcionProducto);
            precio = (TextView) itemView.findViewById(R.id.tvPrecioProducto);
        }
    }

    public List<>
}
