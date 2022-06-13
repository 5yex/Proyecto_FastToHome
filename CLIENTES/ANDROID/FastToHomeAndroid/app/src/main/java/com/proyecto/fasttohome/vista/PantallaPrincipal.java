package com.proyecto.fasttohome.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.proyecto.fasttohome.R;
import com.proyecto.fasttohome.modelo.Direccion;
import com.proyecto.fasttohome.modelo.Peticion;
import com.proyecto.fasttohome.modelo.Usuario;
import com.proyecto.fasttohome.vista.login.PantallaLogin;
import com.proyecto.fasttohome.vista.pedido.SeleccionarProductos;
import com.proyecto.fasttohome.vista.pedido.seleccionarTransporteZona;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PantallaPrincipal extends AppCompatActivity {

    private Usuario user;
    private Direccion direccion;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pantalla_principal);
        queue = Volley.newRequestQueue(PantallaPrincipal.this);
        user = (Usuario) getIntent().getExtras().getSerializable("user");
        direccion = new Direccion();
        obtenerDatosUsuario();
        System.out.println("User: " + user.getJSON());
        System.out.println("Direccion: " + direccion.getJSON());
    }

    public void obtenerDatosUsuario() {
        String url = getString(R.string.apiUrl);
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
                    user.setEmail(datos.getString("Email"));
                    user.setNombre(datos.getString("Nombre"));
                    user.setApellidos(datos.getString("apellidos"));
                    user.setDni(datos.getString("Dni"));
                    user.setId_direccion(datos.getInt("direccion_id"));
                    user.setRol(datos.getString("Rol"));
                    user.setTlf(datos.getString("tlf"));
                    obtenerDireccionUsuario();
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(PantallaPrincipal.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
                finish();
            }
        }, error -> {
            Toast.makeText(PantallaPrincipal.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show();
            finish();
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("DATA", new Peticion("getUsuario", user.getJSON()).getJSON());
                return params;
            }
        };
        queue.add(request);
    }
    public void obtenerDireccionUsuario() {
        String url = getString(R.string.apiUrl);
        StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
            System.out.println(response);
            try {
                JSONObject resp = new JSONObject(response);
                if ((resp.getBoolean("error")) == true) {
                    throw new VolleyError(resp.getString("datos"));
                } else {
                    JSONObject datos = resp.getJSONArray("datos").getJSONObject(0);
                    direccion.setCalle(datos.getString("Calle"));
                    direccion.setNumero(datos.getInt("Numero"));
                    direccion.setCiudad(datos.getString("Ciudad"));
                    direccion.setCodigo_postal(datos.getInt("CP"));
                    direccion.setOtros(datos.getString("Otros"));
                    direccion.setCoordenadas(datos.getString("Coordenadas"));
                    direccion.setId_direccion(datos.getInt("id"));
                }
            } catch (JSONException | VolleyError e) {
                Toast.makeText(PantallaPrincipal.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
                finish();
            }
        }, error -> {
            Toast.makeText(PantallaPrincipal.this, "ERROR DE CONEXIÓN = " + error, Toast.LENGTH_SHORT).show();
            finish();
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("DATA", new Peticion("obtener_direccion", user.getJSON()).getJSON());
                System.out.println("Imprimir direccion");
                return params;
            }
        };
        queue.add(request);
    }
    public void pasarPantallaUbicacion(View view){
        Intent i = new Intent(this, seleccionarTransporteZona.class );
        i.putExtra("user",user);
        i.putExtra("direccion",direccion);
        startActivity(i);
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(PantallaPrincipal.this);
        builder.setTitle("ATENCIÓN").setMessage("Si sales de aquí, cerrarás la sesión y tendrás que iniciar sesión de nuevo, ¿Seguro que quieres salir?");
        builder.setNegativeButton("SEGUIR AQUÍ",null);
        builder.setPositiveButton("CERRAR SESIÓN", (dialogInterface, i) -> {
            Intent ia = new Intent(this, PantallaLogin.class );
            startActivity(ia);
        }).show();
    }
}