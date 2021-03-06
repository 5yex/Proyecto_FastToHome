package com.proyecto.fasttohome.vista.login;


import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Peticion;
import com.proyecto.fasttohome.modelo.Usuario;
import com.proyecto.fasttohome.vista.PantallaPrincipal;
import com.proyecto.fasttohome.vista.pedido.seleccionarTransporteZona;
import com.proyecto.fasttohome.vista.registro.registroPaso1DatosUsuario;

import org.json.JSONException;
import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase con la Pantalla de Logueo
 */
public class PantallaLogin extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Usuario user;

    /**
     * Método para inicializar el activity pantalla login en su creación
     *
     * @param savedInstanceState Contiene los datos más recientes del activity en caso de ser recargado,
     *                           y los enviados desde el activity padre.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new Usuario();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        leerCuentaGuardada();
        setContentView(R.layout.activity_pantalla_login);
        email = findViewById(R.id.eTEmail);
        password = findViewById(R.id.eTPassword);
        if (getIntent().getExtras() != null) {
            email.setText(getIntent().getExtras().getString("email"));
        }
    }

    /**
     * Carga el Intent de la pantalla principal y le pasa el usuario
     */
    public void irPrincipal() {
        Intent i = new Intent(this, PantallaPrincipal.class);
        i.putExtra("user", user);
        startActivity(i);
    }



    /**
     * Método para ir al comienzo del registro
     *
     * @param view
     */
    public void irRegistro(View view) {
        Intent i = new Intent(this, registroPaso1DatosUsuario.class);
        i.putExtra("funcion", "registro");
        i.putExtra("user", user);
        startActivity(i);
    }



    /**
     * Método que lanza el botón iniciar sesión para hacer su acción.
     *
     * @param view
     */
    public void comprobarPass(View view) {
        checkPass(false);
    }

    /**
     * Método para comprobar el usuario y si existe, la contraseña llamando al apiRest con volley
     *
     * @param silent En caso false, realiza un funcionamiento dando info al usuario de los valores que ha introducido mal
     *               <p>
     *               En caso true, realiza un funcinoamiento silencioso para cuando es usado para cuando hace auto-login con
     *               los datos persistidos de la aplicación.
     */
    public void checkPass(Boolean silent) {
        //String url = "http://10.0.2.2/php/webService/api.php";
        //Url del archivo strings.xml
        String url = getString(R.string.apiUrl);
        RequestQueue queue = Volley.newRequestQueue(PantallaLogin.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            try {
                JSONObject resp = new JSONObject(response);
                if ((resp.getBoolean("error")) == true) {
                    throw new VolleyError(resp.getString("datos"));
                } else {
                    JSONObject datos = resp.getJSONArray("datos").getJSONObject(0);
                    if(silent){
                        if(user.getPassword().equals(datos.getString("password")) ){
                            user.setId(datos.getInt("id"));
                            terminarInicioSesion();
                        }
                    }else{
                        user.setPassword(datos.getString("password"));
                        user.setId(datos.getInt("id"));
                        if (BCrypt.checkpw(password.getText().toString(), user.getPassword())) {
                            terminarInicioSesion();
                        } else {
                            if(!silent){
                                Toast.makeText(PantallaLogin.this, "Tu contraseña es incorrecta", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            } catch (JSONException | VolleyError e) {
                if(!silent) {
                    Toast.makeText(PantallaLogin.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }, error -> Toast.makeText(PantallaLogin.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                if(!silent){
                    user.setEmail(email.getText().toString());
                }
                params.put("DATA", new Peticion("getHash", user.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }

    /**
     * Metodo ejecutado al finalizar un inicio de sesión válido
     * Llama al método salvarCuenta para persistir la cuenta
     */
    private void terminarInicioSesion() {
        salvarCuenta(user);
        Toast.makeText(PantallaLogin.this, "Has iniciado sesión correctamente", Toast.LENGTH_SHORT).show();
        irPrincipal();
    }
    /**
     * Método que comprueba si hay una cuenta persistida
     *
     * En caso de que la haya, llamar a checkPass para comenzar un inicio de sesión silencioso
     * que comprueba si la cuenta persistida es válida o no de manera transparente al usuario.
     */
    public void leerCuentaGuardada() {
        SharedPreferences sharedPreferences = getSharedPreferences("fasttohome", MODE_PRIVATE);
        String email = sharedPreferences.getString("email", null);
        String hash = sharedPreferences.getString("hash", null);
        System.out.println(email + hash);
        if (email != null && !email.isEmpty()  && hash != null && !hash.isEmpty()) {
            user.setPassword(hash);
            user.setEmail(email);
            checkPass(true);
        }

    }

    /**
     * Perodo que persiste la cuenta usando SharedPreferences, en modo privado.
     *
     * Guardaría el email y un hash de Bcrypt seguro.
     * @param user
     */
    public void salvarCuenta(Usuario user) {
        //.edit().clear().apply();
        System.out.println("salvarCuenta");
        SharedPreferences sharedPreferences = getSharedPreferences("fasttohome", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", user.getEmail());
        editor.putString("hash", user.getPassword());
        editor.apply();
    }

    @Override
    public void onBackPressed() {
    }
}


