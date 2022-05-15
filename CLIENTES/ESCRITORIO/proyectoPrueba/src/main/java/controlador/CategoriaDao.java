/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.google.gson.JsonArray;
import java.util.ArrayList;
import modelo.Categoria;
import modelo.Peticion;

/**
 *
 * @author Jesus
 */
public class CategoriaDao {
    
    public static boolean nuevoUsuario(Categoria categoria) {
        return gestion.hacerConsulta(new Peticion("nueva_categoria", categoria.getJSON()));
    }
    
    public static ArrayList<Categoria> obtenerCategorias(Categoria categoria){
        
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("obtener_categorias", categoria.getJSON()));

        ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject usuarioJson = jsonArray.get(i).getAsJsonObject();

            user.setDni(usuarioJson.get("Dni").getAsString());
            user.setEmail(usuarioJson.get("Email").getAsString());
            user.setId(usuarioJson.get("id").getAsInt());
            if (!usuarioJson.get("direccion_id").isJsonNull()) {
                user.setId_direccion(usuarioJson.get("direccion_id").getAsInt());
            }
            user.setNombre(usuarioJson.get("Nombre").getAsString());
            user.setPassword(usuarioJson.get("password").getAsString());
            //user.setRol(usuarioJson.get("Rol").getAsString());
            user.setTlf(usuarioJson.get("tlf").getAsString());
            
            listaCategorias.add(user);

        }
        return listaCategorias;
    }
}
