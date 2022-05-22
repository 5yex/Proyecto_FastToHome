/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pedido;
import modelo.Peticion;

/**
 *
 * @author Jesus
 */
public class PedidoDao{
    
    public static ArrayList<Pedido> seleccionPedidosPagados() {
        
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("obtener_pedidos_pagados", null));

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
    
    public static ArrayList<Pedido> seleccionPedidosEnPreparacion() {
        
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("obtener_pedidos_en_preparacion", null));

        ArrayList<Pedido> listaPedidosEnPreparacion = new ArrayList<Pedido>();

        for (int i = 0; i < jsonArray.size(); i++) {
            Pedido pedido = new Pedido();
            
            JsonObject pedidoJson = jsonArray.get(i).getAsJsonObject();
            
            pedido.setId_pedido(pedidoJson.get("id").getAsInt());
            pedido.setId_usuario(pedidoJson.get("id_usuario").getAsInt());
            //pedido.setFecha_hora(pedidoJson.get("fecha_hora").getAsString());
            pedido.setEstado(pedidoJson.get("estado").getAsString());
            pedido.setTotal(pedidoJson.get("total").getAsDouble());
            pedido.setTransporte(pedidoJson.get("transporte").getAsString());
            
            
            listaPedidosEnPreparacion.add(pedido);

        }
        return listaPedidosEnPreparacion;
    }
    
    public static ArrayList<Pedido> seleccionTodosPedidos() {
        SimpleDateFormat dateParser = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
        
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("obtener_todos_pedidos", null));

        ArrayList<Pedido> listaPedidosEnPreparacion = new ArrayList<Pedido>();

        for (int i = 0; i < jsonArray.size(); i++) {
            Pedido pedido = new Pedido();
            
            JsonObject pedidoJson = jsonArray.get(i).getAsJsonObject();
            
            pedido.setId_pedido(pedidoJson.get("id").getAsInt());
            pedido.setId_usuario(pedidoJson.get("id_usuario").getAsInt());
            String fechaActual = pedidoJson.get("fecha_hora").getAsString();
            
            try {
                pedido.setFecha_hora(dateParser.parse(fechaActual));
            } catch (ParseException ex) {
                Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            pedido.setEstado(pedidoJson.get("estado").getAsString());
            pedido.setTotal(pedidoJson.get("total").getAsDouble());
            pedido.setTransporte(pedidoJson.get("transporte").getAsString());
            
            
            listaPedidosEnPreparacion.add(pedido);

        }
        return listaPedidosEnPreparacion;
    }
}
