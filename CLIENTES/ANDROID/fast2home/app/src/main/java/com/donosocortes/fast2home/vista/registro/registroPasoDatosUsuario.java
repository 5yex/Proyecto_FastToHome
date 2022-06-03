package com.donosocortes.fast2home.vista.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.donosocortes.fast2home.R;
import com.donosocortes.fast2home.modelo.Direccion;
import com.donosocortes.fast2home.modelo.Usuario;

public class registroPasoDatosUsuario extends AppCompatActivity {
    Usuario user;
    Direccion direccion;
    EditText nombre;
    EditText apellidos;
    EditText dni;
    EditText telefono;
    EditText email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paso_datos_usuario);

        nombre = findViewById(R.id.etNombre);
        apellidos = findViewById(R.id.etApellidos);
        dni = findViewById(R.id.etDni);
        telefono = findViewById(R.id.etTelefono);
        email = findViewById(R.id.eTEmail);
    }


    public void irPartePassword(View view) {
        Intent i = new Intent(this, registroPasoPassword.class );
        i.putExtra("user", user);
        i.putExtra("direccion", direccion);
        startActivity(i);
    };

    private static long back_pressed;
    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast.makeText(getBaseContext(), "Presiona otra vez sin quieres salir del registro!",Toast.LENGTH_SHORT).show();
        }
        back_pressed = System.currentTimeMillis();
    }
}