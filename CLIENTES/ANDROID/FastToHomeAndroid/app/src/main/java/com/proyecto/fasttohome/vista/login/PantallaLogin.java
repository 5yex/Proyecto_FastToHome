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

public class PantallaLogin extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_pantalla_login);
        email = findViewById(R.id.eTEmail);
        password = findViewById(R.id.eTPassword);
        if(getIntent().getExtras() != null){
            email.setText(getIntent().getExtras().getString("email"));
        }


    }

    public void irPrincipal() {
       Intent i = new Intent(this, PantallaPrincipal.class );
       i.putExtra("user", user);
       startActivity(i);
    };

    public void irRegistro(View view) {
        Intent i = new Intent(this, registroPaso1DatosUsuario.class );
        i.putExtra("funcion","registro");
        i.putExtra("user", user);
        startActivity(i);
    };



    /**
     * Comprueba la contrasña llamando a la api rest con volley
     */
    public void comprobarPass(View view) {
        //String url = "http://10.0.2.2/php/webService/api.php";
        //Url del archivo strings.xml
        String url = getString(R.string.apiUrl);
        RequestQueue queue = Volley.newRequestQueue(PantallaLogin.this);
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
                        terminarInicioSesion();
                    }else {
                        Toast.makeText(PantallaLogin.this, "Tu contraseña es incorrecta", Toast.LENGTH_SHORT).show();
                    }
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(PantallaLogin.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, error -> Toast.makeText(PantallaLogin.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                user = new Usuario();
                user.setEmail(email.getText().toString());
                params.put("DATA", new Peticion("getHash", user.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }

    private void terminarInicioSesion() {
        salvarCuenta(user);
        Toast.makeText(PantallaLogin.this, "Has iniciado sesión correctamente", Toast.LENGTH_SHORT).show();
        irPrincipal();
    }

    public void leerCuentaGuardada(){
        user = new Usuario();
        SharedPreferences sharedPreferences = getSharedPreferences("fasttohome", MODE_PRIVATE);
        user.setId(sharedPreferences.getInt(""));
    }

    public void salvarCuenta(Usuario user) {
        SharedPreferences sharedPreferences = getSharedPreferences("fasttohome", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("user_id",user.getId());
        editor.putString("hash",user.getPassword());
        editor.apply();
    }

    @Override
    public void onBackPressed() {}
}


