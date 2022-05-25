/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.donosocortes.fast2home.controlador;

import com.donosocortes.fast2home.modelo.Categoria;
import com.donosocortes.fast2home.modelo.Peticion;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;


/**
 *
 * @author Jesus
 */
public class CategoriaDao {

    public static boolean nuevoUsuario(Categoria categoria) {
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
