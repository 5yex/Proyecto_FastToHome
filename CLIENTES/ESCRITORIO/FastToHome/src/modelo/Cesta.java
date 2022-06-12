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
public class Cesta{
    
    /**
     * Número que identifica la cesta en la base de datos
     */
    private int id_cesta;
    
    /**
     * Número que identifica el producto introducido en la cesta en la base de datos
     */
    private int id_producto;
    
    /**
     * Número que identifica el pedido al que pertenece la cesta
     */
    private int id_pedido;
    
    /**
     * Cantidad de un producto
     */
    private int cantidad;
    
    /**
     * Contruye una Cesta con parametros a <code>null</code>
     */
    public Cesta() {
    }
    
    /**
     * Contruye una Cesta con los parametros indicado
     * 
     * @param id_cesta Número que identifica la cesta en la base de datos
     * @param id_producto Número que identifica el producto introducido en la cesta en la base de datos
     * @param id_pedido Número que identifica el pedido al que pertenece la cesta
     * @param cantidad Cantidad de un producto
     */
    public Cesta(int id_cesta, int id_producto, int id_pedido, int cantidad) {
        this.id_cesta = id_cesta;
        this.id_producto = id_producto;
        this.id_pedido = id_pedido;
        this.cantidad = cantidad;
    }
    
    /**
     * Contruye una Cesta con los parametros indicado
     * 
     * @param id_producto Número que identifica el producto introducido en la cesta en la base de datos
     * @param id_pedido Número que identifica el pedido al que pertenece la cesta
     * @param cantidad Cantidad de un producto
     */
    public Cesta(int id_producto, int id_pedido, int cantidad) {
        this.id_producto = id_producto;
        this.id_pedido = id_pedido;
        this.cantidad = cantidad;
    }
    
    /**
     * Devuelve el número que identifica el producto introducido en la cesta en la base de datos
     * 
     * @return número que identifica el producto introducido en la cesta en la base de datos
     * @since 1.0
     */
    public int getId_cesta() {
        return id_cesta;
    }
    
    /**
     * Establece el número que identifica el producto introducido en la cesta en la base de datos
     *
     * @param id_cesta Número que identifica el producto introducido en la cesta en la base de datos
     * @since 1.0
     */
    public void setId_cesta(int id_cesta) {
        this.id_cesta = id_cesta;
    }
    
    /**
     * Devuelve el número que identifica el producto introducido en la cesta en la base de datos
     * 
     * @return Número que identifica el producto introducido en la cesta en la base de datos
     * @since 1.0
     */
    public int getId_producto() {
        return id_producto;
    }
    
    /**
     * Establece el número que identifica el producto introducido en la cesta en la base de datos
     * 
     * @param id_producto Número que identifica el producto introducido en la cesta en la base de datos
     * @since 1.0
     */
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    
    /**
     * Devuelve el número que identifica el pedido al que pertenece la cesta
     * 
     * @return Número que identifica el pedido al que pertenece la cesta
     * @since 1.0
     */
    public int getId_pedido() {
        return id_pedido;
    }
    
    /**
     * Establece el número que identifica el pedido al que pertenece la cesta
     * 
     * @param id_pedido Número que identifica el pedido al que pertenece la cesta
     * @since 1.0
     */
    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }
    
    /**
     * Devuelve la cantidad de un producto
     * 
     * @return Cantidad de un producto
     * @since 1.0
     */
    public int getCantidad() {
        return cantidad;
    }
    
    /**
     * Establece la cantidad de un producto
     * 
     * @param cantidad Cantidad de un producto
     * @since 1.0
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    /**
     * Devuelve el objeto de tipo Cesta en forma de JSon
     * 
     * @return el objeto de tipo Cesta en forma de JSon
     */
    public String getJSON(){
       return new Gson().toJson(this);
    }
    
    /**
     * Devuelve una cadena con los atributos del objeto de tipo Cesta
     *
     * @return Cadena con los atributos del objeto de tipo Cesta
     * @since 1.0
     */
    @Override
    public String toString() {
        return "Cesta{" + "id_cesta=" + id_cesta + ", id_producto=" + id_producto + ", id_pedido=" + id_pedido + ", cantidad=" + cantidad + '}';
    }
    
    
}
