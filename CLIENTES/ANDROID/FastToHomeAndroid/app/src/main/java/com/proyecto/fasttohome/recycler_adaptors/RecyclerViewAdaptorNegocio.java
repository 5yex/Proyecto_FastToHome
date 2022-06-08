package com.proyecto.fasttohome.recycler_adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Negocio;

import java.util.List;

public class RecyclerViewAdaptorNegocio extends RecyclerView.Adapter<RecyclerViewAdaptorNegocio.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre, descripcion;
        private Button pedir;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.tvNombreNegocio);
            descripcion = (TextView) itemView.findViewById(R.id.tvDescripcionNegocio);
            //categoria = (TextView) itemView.findViewById(R.id.tvCategoriaNegocio);

            pedir = (Button) itemView.findViewById(R.id.pedir);
            pedir.setOnClickListener(new View.OnClickListener() {

            });

        }





    }

    public List<Negocio> listaNegocios;

    public RecyclerViewAdaptorNegocio(List<Negocio> listaNegocios) {
        this.listaNegocios = listaNegocios;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_negocio,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(listaNegocios.get(position).getNombre());
        holder.descripcion.setText(listaNegocios.get(position).getDescripcion());
        //holder.categoria.setText(listaNegocios.get(position).getId_categoria());
    }

    @Override
    public int getItemCount() {
        return listaNegocios.size();
    }
}
