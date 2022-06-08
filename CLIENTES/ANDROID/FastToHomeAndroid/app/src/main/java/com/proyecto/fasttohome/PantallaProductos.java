package com.proyecto.fasttohome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.proyecto.fasttohome.recycler_adaptors.RecyclerViewAdaptorProducto;

public class PantallaProductos extends AppCompatActivity {

    private RecyclerView recyclerViewProducto;
    private RecyclerViewAdaptorProducto adaptorProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_productos);
    }
}