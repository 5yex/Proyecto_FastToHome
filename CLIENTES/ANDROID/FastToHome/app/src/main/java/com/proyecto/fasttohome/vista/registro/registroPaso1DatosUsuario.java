package com.proyecto.fasttohome.vista.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Direccion;
import com.proyecto.fasttohome.modelo.Usuario;


public class registroPaso1DatosUsuario extends AppCompatActivity {
    Usuario user = new Usuario();
    Direccion direccion = new Direccion();
    EditText nombre;
    EditText apellidos;
    EditText dni;
    EditText telefono;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getSupportActionBar().hide();
        setContentView(R.layout.activity_registro_paso_datos_usuario);

        nombre = findViewById(R.id.etNombre);
        apellidos = findViewById(R.id.etApellidos);
        dni = findViewById(R.id.etDni);
        telefono = findViewById(R.id.etTelefono);
        email = findViewById(R.id.ediTextemail);


    }


    public void irPasoPassword(View view) {
        //Transporte de los datos
        String name = nombre.getText().toString();
        String ape = apellidos.getText().toString();
        String nif = dni.getText().toString();
        String numTelefono = telefono.getText().toString();
        String correo = email.getText().toString();
        user.setNombre(nombre.getText().toString());
        user.setApellidos(apellidos.getText().toString());
        user.setDni(dni.getText().toString());
        user.setTlf(telefono.getText().toString());
        user.setEmail(email.getText().toString());

        Intent i = new Intent(this, registroPaso2Password.class);

        i.putExtra("user", user);
        i.putExtra("direccion", direccion);

        startActivity(i);
    }

    ;

    private static long back_pressed;

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast.makeText(getBaseContext(), "Presiona otra vez sin quieres salir del registro!", Toast.LENGTH_SHORT).show();
        }
        back_pressed = System.currentTimeMillis();
    }
}