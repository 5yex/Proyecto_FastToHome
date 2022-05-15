/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
    
    public static ArrayList<Categoria> obtenerCategorias(){
        Categoria categoria = new Categoria();
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("obtener_categorias", categoria.getJSON()));

        ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject categoriaJson = jsonArray.get(i).getAsJsonObject();

            categoria.setId(categoriaJson.get("id").getAsInt());
            categoria.setNombre(categoriaJson.get("Nombre").getAsString());
            
            listaCategorias.add(categoria);

        }
        return listaCategorias;
    }
}
