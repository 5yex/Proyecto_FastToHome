package com.proyecto.fasttohome.vista.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.util.Validaciones;
import com.proyecto.fasttohome.modelo.Direccion;
import com.proyecto.fasttohome.modelo.Usuario;

import org.mindrot.jbcrypt.BCrypt;

public class registroPaso2Password extends AppCompatActivity {
    Usuario user;
    Direccion direccion;
    Button boton;
    String funcion;

    EditText password;
    EditText passwordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_registro_paso_password);

        boton = findViewById(R.id.buttonUsuario);
        user = (Usuario) getIntent().getExtras().getSerializable("user");
        funcion = getIntent().getExtras().getString("funcion");
        direccion = (Direccion) getIntent().getExtras().getSerializable("direccion");

        password = findViewById(R.id.etPasswordR);
        passwordConfirm = findViewById(R.id.etPasswordConfirmR);

        System.err.println(user.getJSON()+direccion.getJSON());



    }

    public void irPasoDireccionFinal(View view) {

        String pass = password.getText().toString();
        String passConfirm = passwordConfirm.getText().toString();

        if(pass.length() > 0 && passConfirm.length() > 0){
            if(Validaciones.validar(pass,getString(R.string.patron_pass))){
                if(Validaciones.validar(passConfirm,getString(R.string.patron_pass))){
                    if(pass.compareTo(passConfirm) == 0){
                        user.setPassword(BCrypt.hashpw(password.getText().toString(), BCrypt.gensalt(10)));

                        Intent i = new Intent(this, registroPaso3Direccion.class );
                        i.putExtra("user", user);
                        i.putExtra("direccion", direccion);
                        i.putExtra("funcion","registro");
                        startActivity(i);

                    }else{
                        Toast notificacion = Toast.makeText(this,"Lo campos contraseña y confirmar contraseña deben coincidir.",Toast.LENGTH_LONG);
                        notificacion.show();
                    }
                }else{
                    Toast notificacion = Toast.makeText(this,"Patrón incorrecto. Mínimo 8 caracteres, una mayúscula y un número",Toast.LENGTH_LONG);
                    notificacion.show();
                }
            }else{
                Toast notificacion = Toast.makeText(this,"Patrón incorrecto. Mínimo 8 caracteres, una mayúscula y un número",Toast.LENGTH_LONG);
                notificacion.show();
            }

        }else {
            Toast notificacion = Toast.makeText(this, "No puedes dejar ningún campo vacío", Toast.LENGTH_LONG);
            notificacion.show();
        }
    };
}