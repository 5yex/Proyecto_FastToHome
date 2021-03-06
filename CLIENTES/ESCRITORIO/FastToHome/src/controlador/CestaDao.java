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

/**
 *
 * @author Jesus
 */
public class CestaDao {
    
    public static ArrayList<Cesta> obtenerContenidoCestaPedido(Pedido pedido){
        
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("contenido_cesta_pedido", pedido.getJSON()));

        ArrayList<Cesta> contenidoCesta = new ArrayList<>();

        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                Cesta elementoCesta = new Cesta();

                JsonObject cestaJson = jsonArray.get(i).getAsJsonObject();
                
                elementoCesta.setId_cesta(cestaJson.get("id").getAsInt());
                elementoCesta.setCantidad(cestaJson.get("Cantidad").getAsInt());
                elementoCesta.setId_pedido(cestaJson.get("id_pedido").getAsInt());
                elementoCesta.setId_producto(cestaJson.get("id_producto").getAsInt());

                contenidoCesta.add(elementoCesta);

            }
        }

        return contenidoCesta;
    }
    
}
