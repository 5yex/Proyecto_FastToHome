package com.proyecto.fasttohome.vista.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;


import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Direccion;
import com.proyecto.fasttohome.modelo.Usuario;

import org.mindrot.jbcrypt.BCrypt;

public class registroPaso2Password extends AppCompatActivity {
    Usuario user;
    Direccion direccion;

    EditText password;
    EditText passwordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_registro_paso_password);

        user = (Usuario) getIntent().getExtras().getSerializable("user");
        direccion = (Direccion) getIntent().getExtras().getSerializable("direccion");

        password = findViewById(R.id.etPasswordR);
        passwordConfirm = findViewById(R.id.etPasswordConfirmR);

        System.err.println(user.getJSON()+direccion.getJSON());



    }

    public void irPasoDireccionFinal(View view) {
        user.setPassword(BCrypt.hashpw(password.getText().toString(), BCrypt.gensalt(10)));
        Intent i = new Intent(this, registroPaso3Direccion.class );
        i.putExtra("user", user);
        i.putExtra("direccion", direccion);
        startActivity(i);
    };
}