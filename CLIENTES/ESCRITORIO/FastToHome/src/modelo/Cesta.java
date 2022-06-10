/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.google.gson.Gson;

/**
 * Clase que representa la cesta con los productos del pedido
 * 
 * @author Jose Miguel Cálderón, Jesús Rueda
 * @version 1.0
 * @since 1.0
 */
public class Cesta {
    
    /**
     * Número que identifica la cesta en la base de datos
     */
    private int id_cesta;
    
    /**
     * 
     */
    private int id_producto;
    private int id_pedido;
    private int cantidad;

    public Cesta() {
    }

    public Cesta(int id_cesta, int id_producto, int id_pedido, int cantidad) {
        this.id_cesta = id_cesta;
        this.id_producto = id_producto;
        this.id_pedido = id_pedido;
        this.cantidad = cantidad;
    }

    public Cesta(int id_producto, int id_pedido, int cantidad) {
        this.id_producto = id_producto;
        this.id_pedido = id_pedido;
        this.cantidad = cantidad;
    }

    public int getId_cesta() {
        return id_cesta;
    }

    public void setId_cesta(int id_cesta) {
        this.id_cesta = id_cesta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getJSON(){
       return new Gson().toJson(this);
    }
}
