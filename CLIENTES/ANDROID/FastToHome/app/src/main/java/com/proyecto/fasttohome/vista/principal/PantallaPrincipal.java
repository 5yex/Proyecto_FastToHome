package com.proyecto.fasttohome.vista.principal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Usuario;

public class PantallaPrincipal extends AppCompatActivity {

    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pantalla_principal);

        user = (Usuario) getIntent().getExtras().getSerializable("user");
        System.out.println("User: " + user.toString());
    }





}