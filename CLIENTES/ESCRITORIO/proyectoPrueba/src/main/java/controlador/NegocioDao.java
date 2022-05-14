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

    public static Negocio negocioDeMercader(Usuario user) {
        Negocio negocio = new Negocio();
        JsonObject respuesta = gestion.consultaSeleccionUnico(new Peticion("mercader_de_usuario", user.getJSON()));

        negocio.setId_direccion(respuesta.get("id_direccion").getAsInt());
        negocio.setId_categoria(respuesta.get("$id_categoria").getAsInt());    
        negocio.setId_mercader(respuesta.get("$id_mercader").getAsInt());
        negocio.setNombre(respuesta.get("$nombre").getAsString());
        negocio.setDescripcion(respuesta.get("$descripcion").getAsString());

        return negocio;
    }

}
