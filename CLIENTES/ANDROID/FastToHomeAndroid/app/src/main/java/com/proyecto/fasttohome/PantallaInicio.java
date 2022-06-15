package com.proyecto.fasttohome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.proyecto.fasttohome.vista.AcercarDe;
import com.proyecto.fasttohome.vista.login.PantallaLogin;
import com.proyecto.fasttohome.vista.pedido.seleccionarTransporteZona;

/**
 * Clase que representa a la pantalla que se muestra al abrir la aplicación
 */
public class PantallaInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
    }

    public void pantallaLogin(View view){
        Intent i = new Intent(this, PantallaLogin.class );
        startActivity(i);
    }
    public void pasarPantallaUbicacion(View view){
        Intent i = new Intent(this, seleccionarTransporteZona.class );
        startActivity(i);
    }

    public void pasarPantallaAcercarDe(View view){
        Intent i = new Intent(this, AcercarDe.class );
        startActivity(i);
    }

}