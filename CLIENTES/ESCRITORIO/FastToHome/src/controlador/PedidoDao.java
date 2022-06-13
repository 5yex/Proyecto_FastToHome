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
import modelo.Negocio;
import modelo.Pedido;
import modelo.Peticion;

/**
 * Clase donde se realizan las consultas realicionadas con los pedidos
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 * @since 1.0
 */
public class PedidoDao {
    
    /**
     * Realiza la consulta para devolver una lista con los pedidos del día pagados 
     * que están almacenados en la base de datos
     * 
     * @param negocio objeto de tipo Negocio del que vamos a obtener sus pedidos
     * @return Lista con los pedidos del día pagados que están almacenados en la base de datos
     */
    public static ArrayList<Pedido> seleccionPedidosPagados(Negocio negocio) {
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("obtener_pedidos_pagados", negocio.getJSON()));

        ArrayList<Pedido> listaPedidosPagados = new ArrayList<Pedido>();

        if (jsonArray != null) {
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

                listaPedidosPagados.add(pedido);

            }
        } else {
            //System.out.println("no hay ningun pedido");
        }
        return listaPedidosPagados;
    }
    
    /**
     * Realiza la consulta para devolver una lista con los pedidos del día en preparación 
     * que están almacenados en la base de datos
     * 
     * @param negocio objeto de tipo Negocio del que vamos a obtener sus pedidos
     * @return Lista con los pedidos del día en preparación que están almacenados en la base de datos
     */
    public static ArrayList<Pedido> seleccionPedidosEnPreparacion(Negocio negocio) {
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("obtener_pedidos_en_preparacion", negocio.getJSON()));

        ArrayList<Pedido> listaPedidosEnPreparacion = new ArrayList<Pedido>();
        if (jsonArray != null) {
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
        } else {
            //System.out.println("no hay ningun pedido");
        }
        return listaPedidosEnPreparacion;
    }
    
    /**
     * Realiza la consulta para devolver una lista con los todos los pedidos del día
     * que están almacenados en la base de datos
     * 
     * @param negocio objeto de tipo Negocio del que vamos a obtener sus pedidos
     * @return Lista con los todos los pedidos del día que están almacenados en la base de datos
     */
    public static ArrayList<Pedido> seleccionTodosPedidos(Negocio negocio) {
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("obtener_todos_pedidos", negocio.getJSON()));

        ArrayList<Pedido> listaPedidosEnPreparacion = new ArrayList<Pedido>();

        if (jsonArray != null) {
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
        } else {
            //System.out.println("no hay ningun pedido");
        }
        return listaPedidosEnPreparacion;
    }
    
    /**
     * Actualiza el estado del pedido de la base de datos y comprueba si se ha actualizado correctamente
     * 
     * @param pedido objeto de tipo Pedido con los datos del pedido a actualizar
     * @return true si se ha actualizado el estado correctamente, false en caso contrario
     */
    public static boolean actualizarEstadoPedido(Pedido pedido) {
        return gestion.hacerConsulta(new Peticion("actualizar_estado_pedido", pedido.getJSON()));
    }
    
    /**
     * Realiza la consulta para devolver un objeto de tipo Pedido
     * 
     * @param pedido objeto de tipo Pedido del que queremos obtener más información
     * @return objeto de tipo Pedido con toda su información
     */
    public static Pedido obtenerPedido(Pedido pedido) {
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String json = pedido.getJSON();
        //hacemos una petición con el comando que deberá realizar el php, y los datos en json    
        Peticion peticion = new Peticion("obtener_pedido_unico", json);
        //mandamos la peticion como consulta selección para obtener valores
        JsonObject pedidoJson = gestion.consultaSeleccionUnico(peticion);
        //de la respuesta, obtenemos el id    
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

        return pedido;
    }
}
