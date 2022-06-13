package com.proyecto.fasttohome.vista.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Peticion;
import com.proyecto.fasttohome.util.Validaciones;
import com.proyecto.fasttohome.modelo.Direccion;
import com.proyecto.fasttohome.modelo.Usuario;
import com.proyecto.fasttohome.vista.PantallaPrincipal;
import com.proyecto.fasttohome.vista.login.PantallaLogin;

import org.json.JSONException;
import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

import java.util.HashMap;
import java.util.Map;

public class registroPaso2Password extends AppCompatActivity {
    Usuario user;
    Direccion direccion;
    Button boton;
    String funcion;

    EditText password;
    EditText passwordConfirm;
    EditText campoActualizar;
    TextView textoActualizar;

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
        campoActualizar = findViewById(R.id.campoActualizar);
        textoActualizar =  findViewById(R.id.textoActualizar);
        password = findViewById(R.id.etPasswordR);
        passwordConfirm = findViewById(R.id.etPasswordConfirmR);

        if (funcion.equals("update")) {
            boton.setText("Actualizar Contraseña");
        }


    }

    public void irPasoDireccionFinal(View view) {

        String pass = password.getText().toString();
        String passConfirm = passwordConfirm.getText().toString();

        if(pass.length() > 0 && passConfirm.length() > 0){
            if(Validaciones.validar(pass,getString(R.string.patron_pass))){
                if(Validaciones.validar(passConfirm,getString(R.string.patron_pass))){
                    if(pass.compareTo(passConfirm) == 0){
                        user.setPassword(BCrypt.hashpw(password.getText().toString(), BCrypt.gensalt(10)));

                        if (funcion.equals("update")) {

                        }
                        if (funcion.equals("registro")) {
                            Intent i = new Intent(this, registroPaso3Direccion.class );
                            i.putExtra("user", user);
                            i.putExtra("direccion", direccion);
                            i.putExtra("funcion","registro");
                            startActivity(i);
                        }
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

    public void comprobarPass(View view) {
        //String url = "http://10.0.2.2/php/webService/api.php";
        //Url del archivo strings.xml
        String url = getString(R.string.apiUrl);
        RequestQueue queue = Volley.newRequestQueue(registroPaso2Password.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            System.out.println(response);
            try {
                JSONObject resp = new JSONObject(response);
                if ((resp.getBoolean("error")) == true) {
                    throw new VolleyError(resp.getString("datos"));
                } else {
                    JSONObject datos = resp.getJSONArray("datos").getJSONObject(0);
                    user.setPassword(datos.getString("password"));
                    user.setId(datos.getInt("id"));
                    if(BCrypt.checkpw(password.getText().toString(),user.getPassword())){
                       actualizarDatos();










                        Intent i = new Intent(this, PantallaLogin.class );
                        i.putExtra("email",user.getEmail());
                        startActivity(i);
                    }else {
                        Toast.makeText(registroPaso2Password.this, "Tu contraseña es incorrecta", Toast.LENGTH_SHORT).show();
                    }
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(registroPaso2Password.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, error -> Toast.makeText(registroPaso2Password.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                user = new Usuario();
                params.put("DATA", new Peticion("getHash", user.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }

    private void actualizarDatos() {
        String url = getString(R.string.apiUrl);
        RequestQueue queue = Volley.newRequestQueue(registroPaso2Password.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            System.out.println(response);
            try {
                JSONObject resp = new JSONObject(response);
                if ((resp.getBoolean("error")) == true) {
                    throw new VolleyError(resp.getString("datos"));
                } else {
                    Toast.makeText(registroPaso2Password.this, "Se ha actualizado con éxito", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, PantallaPrincipal.class);
                    i.putExtra("user", user);
                    startActivity(i);
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(registroPaso2Password.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, error -> Toast.makeText(registroPaso2Password.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("DATA", new Peticion("actualizar_usuario", user.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }
}