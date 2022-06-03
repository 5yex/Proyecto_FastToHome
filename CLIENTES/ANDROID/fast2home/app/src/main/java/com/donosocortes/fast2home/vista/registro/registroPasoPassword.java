package com.donosocortes.fast2home.vista.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.donosocortes.fast2home.R;
import com.donosocortes.fast2home.modelo.Direccion;
import com.donosocortes.fast2home.modelo.Usuario;

public class registroPasoPassword extends AppCompatActivity {
    Usuario user;
    Direccion direccion;

    EditText password;
    EditText passwordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paso_password);

        user = (Usuario) getIntent().getExtras().getSerializable("user");
        direccion = (Direccion) getIntent().getExtras().getSerializable("direccion");

        password = findViewById(R.id.etPassword);
        passwordConfirm = findViewById(R.id.etPasswordConfirm);

        System.err.println(user.getJSON()+direccion.getJSON());
    }

    public void irPasoDireccionFinal(View view) {
        Intent i = new Intent(this, registroPasoDireccionFinal.class );
        i.putExtra("user", user);
        i.putExtra("direccion", direccion);
        startActivity(i);
    };
}