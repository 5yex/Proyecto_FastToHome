package com.proyecto.fasttohome.vista.pedido.recycler_adaptors;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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
import com.proyecto.fasttohome.modelo.Peticion;
import com.proyecto.fasttohome.util.ImagenesUtil;
import com.proyecto.fasttohome.vista.pedido.PantallaDeNegocios;
import com.proyecto.fasttohome.vista.pedido.SeleccionarProductos;
import com.proyecto.fasttohome.modelo.Negocio;
import com.proyecto.fasttohome.modelo.Usuario;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerViewAdaptorNegocio extends RecyclerView.Adapter<RecyclerViewAdaptorNegocio.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre, descripcion;
        private ImageView image;
        private Usuario usuario;
        private Negocio negocio;
        private Button pedir;
        private Context contexto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.tvNombreNegocio);
            descripcion = (TextView) itemView.findViewById(R.id.tvDescripcionNegocio);
            //categoria = (TextView) itemView.findViewById(R.id.tvCategoriaNegocio);

            pedir = (Button) itemView.findViewById(R.id.pedir);
            contexto = itemView.getContext();
            pedir.setOnClickListener(view -> {
                Intent intent = new Intent(contexto, SeleccionarProductos.class);
                /*Pedido pedido = new Pedido (usuario.getId(),negocio.getId_negocio());
                intent.putExtra("pedido",pedido);*/
                intent.putExtra("user",usuario);
                intent.putExtra("negocio",negocio);
                contexto.startActivity(intent);
                //System.out.println("Boton Pulsado por usuario: "+usuario.getNombre() + " Nombre de negocio: "+ nombre.getText().toString());
            });

        }
    }

    public List<Negocio> listaNegocios;
    Usuario usuario;
    public RecyclerViewAdaptorNegocio(List<Negocio> listaNegocios, Usuario usuario) {
        this.listaNegocios = listaNegocios;
        this.usuario = usuario;
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
        holder.usuario = usuario;
        holder.negocio = new Negocio(listaNegocios.get(position).getId_negocio());
        Picasso.get().setLoggingEnabled(true);
        Picasso.get().load(imgUrl).


        //holder.image.setImageBitmap(ImagenesUtil.BaseStringToBitmap(listaNegocios.get(position).getId_img()));
        //holder.categoria.setText(listaNegocios.get(position).getId_categoria());


    }

    @Override
    public int getItemCount() {
        return listaNegocios.size();
    }
}
