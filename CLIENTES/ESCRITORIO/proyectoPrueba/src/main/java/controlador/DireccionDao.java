/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.google.gson.JsonObject;
import modelo.Direccion;
import modelo.Negocio;
import modelo.Peticion;

/**
 *
 * @author Jesus
 */
public class DireccionDao {

    public static boolean nuevaDireccion(Direccion direccion) {
        return gestion.hacerConsulta(new Peticion("nueva_direccion", direccion.getJSON()));
    }

    public static Direccion obtenerDatosDireccionNegocio(Negocio negocio) {
        Direccion direccion = new Direccion();

        String json = negocio.getJSON();
        //hacemos una petición con el comando que deberá realizar el php, y los datos en json    
        Peticion peticion = new Peticion("getUsuario", json);
        //mandamos la peticion como consulta selección para obtener valores
        JsonObject respuesta = gestion.consultaSeleccionUnico(peticion);
    }

}
