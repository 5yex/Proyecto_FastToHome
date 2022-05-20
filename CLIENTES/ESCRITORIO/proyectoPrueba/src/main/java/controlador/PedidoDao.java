/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import modelo.Pedido;
import modelo.Peticion;

/**
 *
 * @author Jesus
 */
public class PedidoDao{
    
    public static ArrayList<Pedido> seleccionPedidosPagados() {
        
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("obtener_usuarios", null));

        ArrayList<Pedido> listaPedidosPagados = new ArrayList<Pedido>();

        for (int i = 0; i < jsonArray.size(); i++) {
            Pedido pedido = new Pedido();
            
            JsonObject pedidoJson = jsonArray.get(i).getAsJsonObject();
            
            pedido.setId_pedido(pedidoJson.get("id").getAsInt());
            pedido.setId_usuario(pedidoJson.get("id_usuario").getAsInt());
            //pedido.setFecha_hora(pedidoJson.get("fecha_hora").getAsString());
            pedido.setEstado(pedidoJson.get("estado").getAsString());
            pedido.setTotal(pedidoJson.get("total").getAsDouble());
            pedido.setTransporte(pedidoJson.get("transporte").getAsString());
            
            
            listaPedidosPagados.add(pedido);

        }
        return listaPedidosPagados;
    }
}
