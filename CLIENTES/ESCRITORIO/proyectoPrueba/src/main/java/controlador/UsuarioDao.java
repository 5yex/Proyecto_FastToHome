/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.google.gson.JsonObject;
import java.util.ArrayList;
import modelo.Peticion;
import modelo.Usuario;

/**
 *
 * @author jmcbg
 */
public class UsuarioDao {

    public static boolean nuevoUsuario(Usuario user) {
        return gestion.hacerConsulta(new Peticion("nuevo_usuario", user.getJSON()));
    }

    public static String obtenerIdCliente(Usuario user) {
        //Lo mismo pero compacto:
        //return gestion.consultaSeleccion(new Peticion("obtener_id_cliente", user.getJSON())).get("id").getAsString();

        //generamos un json con los datos que vamos a pasarle al php, en este caso solo el usuario
        String json = user.getJSON();
        //hacemos una petición con el comando que deberá realizar el php, y los datos en json    
        Peticion peticion = new Peticion("obtener_id_cliente", json);
        //mandamos la peticion como consulta selección para obtener valores
        JsonObject respuesta = gestion.consultaSeleccionUnico(peticion);
        //de la respuesta, obtenemos el id
        String idCliente = respuesta.get("id").getAsString();

        return idCliente;

    }

    public static Usuario getHash(Usuario user) {
        JsonObject ob = gestion.consultaSeleccionUnico(new Peticion("getHash", user.getJSON()));
        if (ob != null) {
            user.setPassword(ob.get("password").getAsString());
            user.setId(ob.get("id").getAsInt());
            return user;
        }
        return null;
    }

    public static Usuario obtenerDatosUsuario(Usuario user) {
        //generamos un json con los datos que vamos a pasarle al php, en este caso solo el usuario
        String json = user.getJSON();
        //hacemos una petición con el comando que deberá realizar el php, y los datos en json    
        Peticion peticion = new Peticion("getUsuario", json);
        //mandamos la peticion como consulta selección para obtener valores
        JsonObject respuesta = gestion.consultaSeleccionUnico(peticion);
        //de la respuesta, obtenemos el id    
        user.setDni(respuesta.get("Dni").getAsString());
        user.setEmail(respuesta.get("Email").getAsString());
        user.setId(respuesta.get("id").getAsInt());
        if(!respuesta.get("direccion_id").isJsonNull()){
                user.setId_direccion(respuesta.get("direccion_id").getAsInt());
        }
        user.setNombre(respuesta.get("Nombre").getAsString());
        user.setPassword(respuesta.get("password").getAsString());
        user.setRol(respuesta.get("Rol").getAsString());
        user.setTlf(respuesta.get("tlf").getAsString());
        
        System.out.println("controlador.UsuarioDao.obtenerDatosUsuario()   "+ user.toString());
        
        return user;
    }
    
    public static boolean actualizarUsuario(Usuario user){
        return gestion.hacerConsulta(new Peticion("actualizar_usuario", user.getJSON()));
    }
    
    public static ArrayList<Usuario> seleccionUsuarios(Usuario user){
        
        gestion.consultaSeleccion(new Peticion("actualizar_usuario", user.getJSON()));
    }

}
