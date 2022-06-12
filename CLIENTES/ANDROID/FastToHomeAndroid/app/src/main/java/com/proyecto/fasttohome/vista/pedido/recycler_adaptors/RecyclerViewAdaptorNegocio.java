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
import com.proyecto.fasttohome.modelo.Direccion;
import com.proyecto.fasttohome.modelo.Pedido;
import com.proyecto.fasttohome.vista.pedido.SeleccionarProductos;
import com.proyecto.fasttohome.modelo.Negocio;
import com.proyecto.fasttohome.modelo.Usuario;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdaptorNegocio extends RecyclerView.Adapter<RecyclerViewAdaptorNegocio.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre, descripcion;
        private ImageView image;
        private Usuario usuario;
        private Negocio negocio;
        private Pedido pedido;
        private
        private Button pedir, info;
        private Context contexto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.tvNombreNegocio);
            image = (ImageView) itemView.findViewById(R.id.imagenNegocio);
            //descripcion = (TextView) itemView.findViewById(R.id.tvDescripcionNegocio);
            //categoria = (TextView) itemView.findViewById(R.id.tvCategoriaNegocio);

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
                intent.putExtra("direccion", direccion);
                contexto.startActivity(intent);
                //System.out.println("Boton Pulsado por usuario: "+usuario.getNombre() + " Nombre de negocio: "+ nombre.getText().toString());
            });
        }
    }

    public List<Negocio> listaNegocios;
    Usuario usuario;

    public RecyclerViewAdaptorNegocio(List<Negocio> listaNegocios, Usuario usuario, Pedido pedido, Direccion direccion) {
        this.listaNegocios = listaNegocios;
        this.usuario = usuario;
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
        //holder.descripcion.setText(listaNegocios.get(position).getDescripcion());
        holder.usuario = usuario;
        Picasso.get().load(negocioActual.getUrl_imagen()).into(holder.image);
        holder.negocio = negocioActual;
        //holder.categoria.setText(listaNegocios.get(position).getId_categoria());
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
