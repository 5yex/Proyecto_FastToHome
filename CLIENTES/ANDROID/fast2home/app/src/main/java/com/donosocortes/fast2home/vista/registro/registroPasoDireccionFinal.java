package com.donosocortes.fast2home.vista.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.donosocortes.fast2home.R;
import com.donosocortes.fast2home.modelo.Direccion;
import com.donosocortes.fast2home.modelo.Usuario;

public class registroPasoDireccionFinal extends AppCompatActivity {
    Usuario user;
    Direccion direccion;
    EditText calle;
    EditText numero;
    EditText codigoPostal;
    EditText ciudad;
    EditText otros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paso_direccion_final);
        calle =  findViewById(R.id.etCalle);
        numero = findViewById(R.id.etNumero);
        codigoPostal = findViewById(R.id.etCodigoPostal);
        ciudad = findViewById(R.id.etCiudad);
        otros = findViewById(R.id.etOtros);
    }
}