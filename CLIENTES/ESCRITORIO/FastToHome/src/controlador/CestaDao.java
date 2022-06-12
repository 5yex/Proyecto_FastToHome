/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import modelo.Cesta;
import modelo.Pedido;
import modelo.Peticion;
import modelo.Usuario;

/**
 *
 * @author Jesus
 */
public class CestaDao {
    
    public static ArrayList<Cesta> obtenerContenidoCestaPedido(Pedido pedido){
        
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("contenido_cesta_pedido", pedido.getJSON()));

        ArrayList<Cesta> contenidoCesta = new ArrayList<Cesta>();

        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                Cesta cesta = new Cesta();

                JsonObject usuarioJson = jsonArray.get(i).getAsJsonObject();

                cesta.setId(usuarioJson.get("id").getAsInt());
                cesta.setDni(usuarioJson.get("Dni").getAsString());
                cesta.setEmail(usuarioJson.get("Email").getAsString());
                cesta.setId(usuarioJson.get("id").getAsInt());
                if (!usuarioJson.get("direccion_id").isJsonNull()) {
                    cesta.setId_direccion(usuarioJson.get("direccion_id").getAsInt());
                }
                cesta.setNombre(usuarioJson.get("Nombre").getAsString());
                cesta.setApellidos(usuarioJson.get("apellidos").getAsString());
                cesta.setPassword(usuarioJson.get("password").getAsString());
                cesta.setRol(usuarioJson.get("Rol").getAsString());
                cesta.setTlf(usuarioJson.get("tlf").getAsString());

                listaUsuarios.add(cesta);

            }
        }

        return listaUsuarios;

    }
    }
    
}
