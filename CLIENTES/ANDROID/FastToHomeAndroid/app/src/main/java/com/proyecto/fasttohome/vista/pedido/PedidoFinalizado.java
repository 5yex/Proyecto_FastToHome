package com.proyecto.fasttohome.vista.pedido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Usuario;
import com.proyecto.fasttohome.vista.PantallaPrincipal;

/**
 * Clase que representa a la pantalla con el resumen del pedido finalizado
 */
public class PedidoFinalizado extends AppCompatActivity {

    Button volver;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pedido_finalizado);
        usuario = (Usuario) getIntent().getExtras().getSerializable("user");
        volver = findViewById(R.id.volver);
        volver.setOnClickListener(view -> {
            Intent i = new Intent(this, PantallaPrincipal.class);
            i.putExtra("user", usuario);
            startActivity(i);
        });
    }
    @Override
    public void onBackPressed() {}

}