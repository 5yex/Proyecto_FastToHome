/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.google.gson.JsonArray;
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
        JsonObject usuarioJson = gestion.consultaSeleccionUnico(peticion);
        //de la respuesta, obtenemos el id    
        user.setDni(usuarioJson.get("Dni").getAsString());
        user.setEmail(usuarioJson.get("Email").getAsString());
        user.setId(usuarioJson.get("id").getAsInt());
        if (!usuarioJson.get("direccion_id").isJsonNull()) {
            user.setId_direccion(usuarioJson.get("direccion_id").getAsInt());
        }
        user.setNombre(usuarioJson.get("Nombre").getAsString());
        user.setApellidos(usuarioJson.get("apellidos").getAsString());
        user.setPassword(usuarioJson.get("password").getAsString());
        user.setRol(usuarioJson.get("Rol").getAsString());
        user.setTlf(usuarioJson.get("tlf").getAsString());

        System.out.println("controlador.UsuarioDao.obtenerDatosUsuario()   " + user.toString());

        return user;
    }

    public static boolean actualizarUsuario(Usuario user) {
        return gestion.hacerConsulta(new Peticion("actualizar_usuario", user.getJSON()));
    }
    
    public static boolean asignarRolMercader(Usuario user) {
        return gestion.hacerConsulta(new Peticion("asignar_rol_mercader", user.getJSON()));
    }
    
    public static boolean asignarRolAdministrador(Usuario user) {
        return gestion.hacerConsulta(new Peticion("asignar_rol_admin", user.getJSON()));
    }

    public static ArrayList<Usuario> seleccionUsuarios(String peticion) {
        
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion(peticion, null));

        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

        for (int i = 0; i < jsonArray.size(); i++) {
            Usuario user = new Usuario();
            
            JsonObject usuarioJson = jsonArray.get(i).getAsJsonObject();
            
            user.setId(usuarioJson.get("id").getAsInt());
            user.setDni(usuarioJson.get("Dni").getAsString());
            user.setEmail(usuarioJson.get("Email").getAsString());
            user.setId(usuarioJson.get("id").getAsInt());
            if (!usuarioJson.get("direccion_id").isJsonNull()) {
                user.setId_direccion(usuarioJson.get("direccion_id").getAsInt());
            }
            user.setNombre(usuarioJson.get("Nombre").getAsString());
            user.setApellidos(usuarioJson.get("apellidos").getAsString());
            user.setPassword(usuarioJson.get("password").getAsString());
            user.setRol(usuarioJson.get("Rol").getAsString());
            user.setTlf(usuarioJson.get("tlf").getAsString());
            
            listaUsuarios.add(user);

        }
        return listaUsuarios;

    }
    
    public static ArrayList<Usuario> obtenerDatosClientes(){
        
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("obtener_usuarios_clientes", null));

        ArrayList<Usuario> listaClientes = new ArrayList<Usuario>();

        for (int i = 0; i < jsonArray.size(); i++) {
            Usuario user = new Usuario();
            JsonObject usuarioJson = jsonArray.get(i).getAsJsonObject();

            user.setDni(usuarioJson.get("Dni").getAsString());
            user.setEmail(usuarioJson.get("Email").getAsString());
            user.setId(usuarioJson.get("id").getAsInt());
            if (!usuarioJson.get("direccion_id").isJsonNull()) {
                user.setId_direccion(usuarioJson.get("direccion_id").getAsInt());
            }
            user.setNombre(usuarioJson.get("Nombre").getAsString());
            user.setPassword(usuarioJson.get("password").getAsString());
            //user.setRol(usuarioJson.get("Rol").getAsString());
            user.setTlf(usuarioJson.get("tlf").getAsString());
            
            listaClientes.add(user);

        }
        return listaClientes;
    }
    
    
    public static ArrayList<Usuario> obtenerDatosAdministradores(){
        
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("obtener_usuarios_clientes", null));

        ArrayList<Usuario> listaClientes = new ArrayList<Usuario>();

        for (int i = 0; i < jsonArray.size(); i++) {
            Usuario user = new Usuario();
            JsonObject usuarioJson = jsonArray.get(i).getAsJsonObject();

            user.setDni(usuarioJson.get("Dni").getAsString());
            user.setEmail(usuarioJson.get("Email").getAsString());
            user.setId(usuarioJson.get("id").getAsInt());
            if (!usuarioJson.get("direccion_id").isJsonNull()) {
                user.setId_direccion(usuarioJson.get("direccion_id").getAsInt());
            }
            user.setNombre(usuarioJson.get("Nombre").getAsString());
            user.setPassword(usuarioJson.get("password").getAsString());
            //user.setRol(usuarioJson.get("Rol").getAsString());
            user.setTlf(usuarioJson.get("tlf").getAsString());
            
            listaClientes.add(user);

        }
        return listaClientes;
    }


}
