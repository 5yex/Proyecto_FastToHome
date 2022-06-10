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
 * Clase donde se realizan las consultas realicionadas con los usuarios
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 * @since 1.0
 */
public class UsuarioDao {
    
    /**
     * Inserta un nuevo usuario en la base de datos y comprueba si se ha insertado
     * 
     * @param user objeto de tipo Usuario con los datos del usuario a insertar
     * @return true si se ha insertado el el usuario corretamente, false en caso contrario
     */
    public static boolean nuevoUsuario(Usuario user) {
        return gestion.hacerConsulta(new Peticion("nuevo_usuario", user.getJSON()));
    }
    
    /**
     * Realiza la consulta para devolver una cadena que identifica al usuario en la base de datos
     * 
     * @param user objeto de tipo Usuario del que queremos obtener el identificador
     * @return una cadena con el identificador del usuario en la base de datos
     */
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
    
    /**
     * Realiza la consulta para obtener la contraseña encriptada y el identificador de un usario en la base de datos
     * 
     * @param user objeto de tipo Usuario con los datos del usaurip
     * @return objeto de tipo usario con la contraseña encriptada e identificador
     */
    public static Usuario getHash(Usuario user) {
        JsonObject ob = gestion.consultaSeleccionUnico(new Peticion("getHash", user.getJSON()));
        if (ob != null) {
            user.setPassword(ob.get("password").getAsString());
            user.setId(ob.get("id").getAsInt());
            return user;
        }
        return null;
    }
    
    /**
     * Realiza la consulta para obtener los datos de un usario de la base de datos
     * 
     * @param user objeto de tipo Usuario del que queremos obtener sus datos
     * @return objeto de tipo Usuario con los datos del usuario
     */
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

        //System.out.println("controlador.UsuarioDao.obtenerDatosUsuario()   " + user.toString());

        return user;
    }
    
    /**
     * Actualiza el usuario en la base de datos y comprueba si se ha actualizado correctamente
     * 
     * @param user objeto de tipo Usuario con los datos del usuario a actualizar
     * @return true si se ha actualizado el usuario en la base de datos 
     */
    public static boolean actualizarUsuario(Usuario user) {
        return gestion.hacerConsulta(new Peticion("actualizar_usuario", user.getJSON()));
    }
    
    /**
     * Realiza la consulta para asignar el rol de mercader a un usuario con el rol de cliente
     * 
     * @param user objeto de tipo Usuario al que se le va asignar el rol de mercader
     * @return true si se ha asignado el rol correctamente, false en caso contrario
     */
    public static boolean asignarRolMercader(Usuario user) {
        return gestion.hacerConsulta(new Peticion("asignar_rol_mercader", user.getJSON()));
    }
    
    /**
     * Realiza la consulta para asignar el rol de administrador a un usuario con el rol de cliente
     * 
     * @param user objeto de tipo Usuario al que se le va asignar el rol de administrador
     * @return true si se ha asignado el rol correctamente, false en caso contrario
     */
    public static boolean asignarRolAdministrador(Usuario user) {
        return gestion.hacerConsulta(new Peticion("asignar_rol_admin", user.getJSON()));
    }

    public static boolean asignarRolCliente(Usuario user) {
        return gestion.hacerConsulta(new Peticion("asignar_rol_cliente", user.getJSON()));
    }

    public static ArrayList<Usuario> seleccionUsuarios(String peticion) {

        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion(peticion, null));

        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

        if (jsonArray != null) {
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
        }

        return listaUsuarios;

    }

    public static ArrayList<Usuario> seleccionUsuariosClientes() {
        return seleccionUsuarios("obtener_usuarios_clientes");
    }

    public static ArrayList<Usuario> seleccionUsuariosAdmin() {
        return seleccionUsuarios("obtener_usuarios_admin");
    }

    public static ArrayList<Usuario> seleccionUsuariosMercader() {
        return seleccionUsuarios("obtener_usuarios_mercader");
    }

    

}
