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
import com.proyecto.fasttohome.modelo.Pedido;
import com.proyecto.fasttohome.vista.pedido.SeleccionarProductos;
import com.proyecto.fasttohome.modelo.Negocio;
import com.proyecto.fasttohome.modelo.Usuario;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

public class RecyclerViewAdaptorNegocio extends RecyclerView.Adapter<RecyclerViewAdaptorNegocio.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre, categoria;
        private ImageView image;
        private Usuario usuario;
        private Negocio negocio;
        private Pedido pedido;
        private Button pedir, info;
        private Context contexto;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.tvNombreNegocio);
            image = (ImageView) itemView.findViewById(R.id.imagenNegocio);
            categoria = (TextView) itemView.findViewById(R.id.tvCategoriaNegocio);

            pedir = (Button) itemView.findViewById(R.id.pedir);
            info = (Button) itemView.findViewById(R.id.infoNeg);
            contexto = itemView.getContext();
            pedir.setOnClickListener(view -> {
                Intent intent = new Intent(contexto, SeleccionarProductos.class);
                /*Pedido pedido = new Pedido (usuario.getId(),negocio.getId_negocio());
                intent.putExtra("pedido",pedido);*/
                intent.putExtra("user", usuario);
                intent.putExtra("negocio", negocio);
                intent.putExtra("pedido", pedido);
                contexto.startActivity(intent);
                //System.out.println("Boton Pulsado por usuario: "+usuario.getNombre() + " Nombre de negocio: "+ nombre.getText().toString());
            });
        }
    }

    private List<Negocio> listaNegocios;
    private HashMap<Integer,Categoria> categorias;
    private Usuario usuario;
    private Pedido pedido;
    public RecyclerViewAdaptorNegocio(List<Negocio> listaNegocios, Usuario usuario, Pedido pedido, HashMap<Integer,Categoria> categorias) {
        this.listaNegocios = listaNegocios;
        this.usuario = usuario;
        this.pedido = pedido;
        this.categorias= categorias;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_negocio, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Negocio negocioActual = listaNegocios.get(position);
        holder.nombre.setText(negocioActual.getNombre());
        System.err.println(categorias.size());
       // holder.categoria.setText(categorias.size());
        holder.usuario = usuario;
        holder.pedido = pedido;
        holder.negocio = negocioActual;
        Picasso.get().load(negocioActual.getUrl_imagen()).into(holder.image);
        holder.info.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(holder.contexto);
            builder.setTitle("INFORMACIÓN DEL NEGOCIO");
            builder.setMessage(negocioActual.getDescripcion()).show();
        });
    }

    @Override
    public int getItemCount() {
        return listaNegocios.size();
    }
}
