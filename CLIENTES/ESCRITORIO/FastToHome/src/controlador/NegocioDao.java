package controlador;

import com.google.gson.JsonObject;
import modelo.Negocio;
import modelo.Peticion;
import modelo.Usuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Clase donde se realizan las consultas realicionadas con los negocios
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 * @since 1.0
 */
public class NegocioDao {
    
    /**
     * Realiza la consulta para insertar un nuevo negocio en la base de datos y comprueba si se ha insertado
     * 
     * @param negocio objeto de tipo Negocio con el negocio a insertar
     * @return true si se ha insertado correctamente
     */
    public static boolean nuevoNegocio(Negocio negocio) {
        return gestion.hacerConsulta(new Peticion("nuevo_negocio", negocio.getJSON()));
    }

    public static Negocio negocioDeMercader(Usuario user) {
        Negocio negocio = new Negocio();
        JsonObject respuesta = gestion.consultaSeleccionUnico(new Peticion("negocio_de_mercader", user.getJSON()));

        if (respuesta == null) {
            return null;
        }
        
        negocio.setId_negocio(respuesta.get("id").getAsInt());
        if (!respuesta.get("direccion_id").isJsonNull()) {
            negocio.setId_direccion(respuesta.get("direccion_id").getAsInt());
        }
        negocio.setId_categoria(respuesta.get("id_categoria").getAsInt());
        negocio.setId_mercader(respuesta.get("id_mercader").getAsInt());
        negocio.setNombre(respuesta.get("Nombre").getAsString());
        negocio.setDescripcion(respuesta.get("Descripcion").getAsString());
        
        if (!respuesta.get("imagenes_id").isJsonNull()) {
             negocio.setId_img(respuesta.get("imagenes_id").getAsInt());
        }

        return negocio;
    }
    
    public static boolean actualizarNegocio(Negocio negocio){
        return gestion.hacerConsulta(new Peticion("actualizar_negocio", negocio.getJSON()));
    }

}
