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

        respuesta.get("id_direccion").getAsInt();
        
        
        
        return negocio;
    }

}
