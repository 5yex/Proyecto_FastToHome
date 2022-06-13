package com.proyecto.fasttohome.vista.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.util.Validaciones;
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

        try {

            if(name.length() > 0 && ape.length() > 0 && nif.length() > 0 && numTelefono.length() > 0 && correo.length() > 0){
                int numero_movil = Integer.parseInt(numTelefono);
                if(validaciones(name,ape,nif,numTelefono,correo)){
                    Intent i = new Intent(this, registroPaso2Password.class);

                    i.putExtra("user", user);
                    i.putExtra("direccion", direccion);

                    startActivity(i);
                }
            }else{
                Toast notificacion = Toast.makeText(this,"No puedes dejar ningún campo vacío.",Toast.LENGTH_SHORT);
                notificacion.show();

            }
        }catch (NumberFormatException ex){
            Toast notificacion = Toast.makeText(this,"El número de teléfono debe ser un entero de 9 cifras que empiece por 6, 7 o 9.",Toast.LENGTH_SHORT);
            notificacion.show();
        }
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

    public boolean validaciones(String name, String ape, String nif, String numTelefono, String correo){
        if(Validaciones.validar(name,getString(R.string.patron_nombre))) {
            user.setNombre(name);
        }else{
            Toast notificacion = Toast.makeText(this,"Nombre que empiece por mayuscula y resto minúsculas",Toast.LENGTH_SHORT);
            notificacion.show();
            return false;
        }

        if(Validaciones.validar(ape,getString(R.string.patron_apellido))) {
            user.setApellidos(ape);
        }else{
            Toast notificacion = Toast.makeText(this,"Apellido que empiece por mayúscula y resto minúsculas, también acepta algunas prenombre como 'del' ",Toast.LENGTH_LONG);
            notificacion.show();
            return false;
        }

        if(Validaciones.validar(nif,getString(R.string.patron_dni))){
            user.setDni(nif);
        }else{
            //Toast
            return false;
        }

        if(Validaciones.validar(numTelefono,getString(R.string.patron_telefono))){
            user.setTlf(numTelefono);
        }else{
            Toast notificacion = Toast.makeText(this,"DNI inválido",Toast.LENGTH_SHORT);
            notificacion.show();
            return false;
        }

        if(Validaciones.validar(correo, getString(R.string.patron_email))){
            user.setEmail(correo);
        }else {
            Toast notificacion = Toast.makeText(this,"Correo inválido. Con '@' y con terminación tras '.' (.es, .com, .org)",Toast.LENGTH_LONG);
            notificacion.show();
            return false;
        }
        return true;
    }
}