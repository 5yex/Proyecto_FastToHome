package com.proyecto.fasttohome.vista;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
import com.proyecto.fasttohome.vista.pedido.PantallaDePedidos;
import com.proyecto.fasttohome.vista.pedido.seleccionarTransporteZona;
import com.proyecto.fasttohome.vista.registro.registroPaso1DatosUsuario;
import com.proyecto.fasttohome.vista.registro.registroPaso2Password;
import com.proyecto.fasttohome.vista.registro.registroPaso3Direccion;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa la pantalla tras el inicio de sesión donde se muestran las opciones para el cliente
 */
public class PantallaPrincipal extends AppCompatActivity {

    private Usuario user;
    private Direccion direccion;
    private RequestQueue queue;
    private TextView nombre, apellidos;

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
        nombre = findViewById(R.id.nombreUser);
        apellidos = findViewById(R.id.apellidosUser);
        System.out.println(user.getJSON());

        //obtener_pedidos_cliente
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
                    nombre.setText(user.getNombre());
                    apellidos.setText(user.getApellidos());
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
                System.out.println((new Peticion("obtener_direccion", user.getJSON()).getJSON()));
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

    public void pasarPantallaPedidos(View view){
        Intent i = new Intent(this, PantallaDePedidos.class );
        i.putExtra("user",user);
        i.putExtra("direccion",direccion);
        startActivity(i);
    }

    public void pasarPantallaActualizarDatos(View view){
        Intent i = new Intent(this, registroPaso1DatosUsuario.class );
        i.putExtra("user",user);
        i.putExtra("funcion","update");
        startActivity(i);
    }

    public void pasarPantallaActualizarDireccion(View view){
        Intent i = new Intent(this, registroPaso3Direccion.class );
        i.putExtra("user",user);
        i.putExtra("direccion",direccion);
        i.putExtra("funcion","update");
        startActivity(i);
    }

    public void pasarPantallaActualizarPassword(View view){
        Intent i = new Intent(this, registroPaso2Password.class );
        i.putExtra("user",user);
        i.putExtra("direccion",direccion);
        i.putExtra("funcion","update");
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(PantallaPrincipal.this);
        builder.setTitle("ATENCIÓN").setMessage("¿Seguro que quieres salir?");
        builder.setNegativeButton("SEGUIR AQUÍ",null);
        builder.setNeutralButton("SALIR DE LA APLICAIÓN",(dialogInterface, i) -> {
            System.exit(0);
        });
        builder.setPositiveButton("CERRAR SESIÓN", (dialogInterface, i) -> {
            getSharedPreferences("fasttohome", MODE_PRIVATE).edit().clear().apply();
            Intent ia = new Intent(this, PantallaLogin.class );
            startActivity(ia);
        }).show();
    }
}