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
 *
 * @author jmcbg
 */
public class NegocioDao {
    
    public static boolean nuevoNegocio(Negocio negocio) {
        return gestion.hacerConsulta(new Peticion("nuevo_negocio", user.getJSON()));
    }

    public static Negocio negocioDeMercader(Usuario user) {
        Negocio negocio = new Negocio();
        JsonObject respuesta = gestion.consultaSeleccionUnico(new Peticion("negocio_de_mercader", user.getJSON()));

        if(respuesta == null){
            return null;
        }
        negocio.setId_direccion(respuesta.get("direccion_id").getAsInt());
        negocio.setId_categoria(respuesta.get("id_categoria").getAsInt());    
        negocio.setId_mercader(respuesta.get("id_mercader").getAsInt());
        negocio.setNombre(respuesta.get("Nombre").getAsString());
        negocio.setDescripcion(respuesta.get("Descripcion").getAsString());

        return negocio;
    }

}
