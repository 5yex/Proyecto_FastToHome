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

                JsonObject cestaJson = jsonArray.get(i).getAsJsonObject();

                cesta.setId(cestaJson.get("id").getAsInt());
                cesta.setDni(cestaJson.get("Dni").getAsString());
                cesta.setEmail(cestaJson.get("Email").getAsString());
                cesta.setId(cestaJson.get("id").getAsInt());
                if (!cestaJson.get("direccion_id").isJsonNull()) {
                    cesta.setId_direccion(cestaJson.get("direccion_id").getAsInt());
                }
                cesta.setNombre(cestaJson.get("Nombre").getAsString());
                cesta.setApellidos(cestaJson.get("apellidos").getAsString());
                cesta.setPassword(cestaJson.get("password").getAsString());
                cesta.setRol(cestaJson.get("Rol").getAsString());
                cesta.setTlf(cestaJson.get("tlf").getAsString());

                contenidoCesta.add(cesta);

            }
        }

        return listaUsuarios;

    }
    }
    
}
