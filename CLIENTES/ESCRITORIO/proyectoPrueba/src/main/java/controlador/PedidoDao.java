/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.google.gson.JsonArray;
import java.util.ArrayList;
import modelo.Peticion;

/**
 *
 * @author Jesus
 */
public class PedidoDao{
    
    public static ArrayList<Pedido> seleccionPedidosPagados() {
        
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("obtener_usuarios", null));

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
            user.setPassword(usuarioJson.get("password").getAsString());
            user.setRol(usuarioJson.get("Rol").getAsString());
            user.setTlf(usuarioJson.get("tlf").getAsString());
            
            listaUsuarios.add(user);

        }
        return listaUsuarios;
    
}
