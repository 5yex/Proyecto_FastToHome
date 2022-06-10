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
 * Clase donde se realizan las consultas realicionadas con la categoria del negocio
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 * @since 1.0
 */
public class CategoriaDao {
    
    /**
     * Crea una nueva categoría y comprueba si se ha creado correctamente
     * 
     * @param categoria objeto de tipo Categoria a crear
     * @return true si se ha creado la categoría con exito
     */
    public static boolean nuevaCategoria(Categoria categoria) {
        return gestion.hacerConsulta(new Peticion("nueva_categoria", categoria.getJSON()));
    }

    public static ArrayList<Categoria> obtenerCategorias() {
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("obtener_categorias", null));

        ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();

        for (int i = 0; i < jsonArray.size(); i++) {
            Categoria categoria = new Categoria();
            JsonObject categoriaJson = jsonArray.get(i).getAsJsonObject();

            categoria.setId(categoriaJson.get("id").getAsInt());
            categoria.setNombre(categoriaJson.get("Nombre").getAsString());

            listaCategorias.add(categoria);

        }
        return listaCategorias;
    }
    
    public static int ObtenerIdPorNombre(Categoria categoria){
         return gestion.consultaSeleccionUnico(new Peticion("obtener_id_categoria", categoria.getJSON())).get("id").getAsInt();
    }
    
}
