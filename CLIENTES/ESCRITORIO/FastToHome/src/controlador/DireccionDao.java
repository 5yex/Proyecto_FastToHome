/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.google.gson.JsonObject;
import modelo.Direccion;
import modelo.Negocio;
import modelo.Peticion;
import modelo.Usuario;

/**
 * Clase donde se realizan las consultas realicionadas con una dirección
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 * @since 1.0
 */
public class DireccionDao {
    
    /**
     * Inserta una nueva dirección en la base de datos y comprueba si se ha insertado correctamente
     * 
     * @param direccion objeto de tipo Direccion a almacenar
     * @return true si se ha almacenado la dirección correctamente, false en caso contrario
     */
    public static boolean nuevaDireccion(Direccion direccion) {
        return gestion.hacerConsulta(new Peticion("nueva_direccion", direccion.getJSON()));
    }
    
    /**
     * Inserta una nueva dirección y devuelve el número que la identifica en la base de datos
     * 
     * @param direccion objeto de tipo Direccion a almacenar
     * @return número que identifica la dirección que se acaba de almacenar en la base de datos
     */
    public static int nuevaDireccionDevuelveId(Direccion direccion) {
        return gestion.consultaSeleccionUnico(new Peticion("nueva_direccion_devuelve_id", direccion.getJSON())).get("last_id").getAsInt();
    }

    /**
     * Realiza la consulta para devolver un objeto de tipo Dirección con la dirección de un negocio
     * 
     * @param negocio objeto de tipo Negocio del que queremos obtener la dirección
     * @return un objeto de tipo Dirección con al dirección de un negocio
     */
    public static Direccion obtenerDireccionNegocio(Negocio negocio) {
        Direccion direccion = new Direccion();

        String json = negocio.getJSON();
        //hacemos una petición con el comando que deberá realizar el php, y los datos en json    
        Peticion peticion = new Peticion("obtener_direccion", json);
        //mandamos la peticion como consulta selección para obtener valores
        JsonObject respuesta = gestion.consultaSeleccionUnico(peticion);
        direccion.setCalle(respuesta.get("Calle").getAsString());
        direccion.setNumero(respuesta.get("Numero").getAsInt());
        direccion.setCiudad(respuesta.get("Ciudad").getAsString());
        direccion.setCodigo_postal(respuesta.get("CP").getAsInt());
        direccion.setOtros(respuesta.get("Otros").getAsString());
        direccion.setCoordenadas(respuesta.get("Coordenadas").getAsInt());
        
        return direccion;
        
    }
    
    /**
     * Realiza la consulta para devolver un objeto de tipo Dirección con la dirección de un usuario
     * 
     * @param usuario objeto de tipo Usuario del que queremos obtener la dirección
     * @return un objeto de tipo Dirección con al dirección de un usuario
     */
    public static Direccion obtenerDireccionUsuario(Usuario usuario) {
        Direccion direccion = new Direccion();

        String json = usuario.getJSON();
        //hacemos una petición con el comando que deberá realizar el php, y los datos en json    
        Peticion peticion = new Peticion("obtener_direccion", json);
        //mandamos la peticion como consulta selección para obtener valores
        JsonObject respuesta = gestion.consultaSeleccionUnico(peticion);
        
        direccion.setCalle(respuesta.get("Calle").getAsString());
        direccion.setNumero(respuesta.get("Numero").getAsInt());
        direccion.setCiudad(respuesta.get("Ciudad").getAsString());
        direccion.setCodigo_postal(respuesta.get("CP").getAsInt());
        direccion.setOtros(respuesta.get("Otros").getAsString());
        direccion.setCoordenadas(respuesta.get("Coordenadas").getAsInt());
        
        return direccion;
        
    }
    
    /**
     * Realiza la consulta para actualizar la dirección y comprueba si se ha actualizado correctamente
     * 
     * @param direccion objeto de tipo Direccion con la dirección a actualizar
     * @return true si se ha realizado la actualización con éxito, false en caso contrario
     */
    public static boolean actualizarDireccion(Direccion direccion){
        return gestion.hacerConsulta(new Peticion("actualizar_direccion", direccion.getJSON()));
    }
    
    

}
