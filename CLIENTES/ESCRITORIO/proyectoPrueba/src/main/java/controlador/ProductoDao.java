

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import modelo.Negocio;
import modelo.Peticion;
import modelo.Producto;

/**
 *
 * @author Jesus
 */
public class ProductoDao {
    public boolean nuevoProducto(Producto product){
        return gestion.hacerConsulta(new Peticion("nuevo_producto", product.getJSON()));
    }
    
    public ArrayList <Producto> selecciónProductosNegocio(Producto product){
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("obtener_usuarios", product.getJSON()));

        ArrayList<Producto> listaProducto = new ArrayList<Producto>();

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject usuarioJson = jsonArray.get(i).getAsJsonObject();

            /*user.setDni(usuarioJson.get("Dni").getAsString());
            user.setEmail(usuarioJson.get("Email").getAsString());
            user.setId(usuarioJson.get("id").getAsInt());
            if (!usuarioJson.get("direccion_id").isJsonNull()) {
                user.setId_direccion(usuarioJson.get("direccion_id").getAsInt());
            }
            user.setNombre(usuarioJson.get("Nombre").getAsString());
            user.setPassword(usuarioJson.get("password").getAsString());
            user.setRol(usuarioJson.get("Rol").getAsString());
            user.setTlf(usuarioJson.get("tlf").getAsString());
            
            listaUsuarios.add(user);*/

        }
        return listaUsuarios;
    }
}
