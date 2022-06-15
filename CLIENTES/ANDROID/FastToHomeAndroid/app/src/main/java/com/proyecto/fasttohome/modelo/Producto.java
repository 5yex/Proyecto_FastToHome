package com.proyecto.fasttohome.modelo;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Clase que representa un producto de un negocio
 *
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 * @since 10
 */
public class Producto implements Serializable {

    /**
     * Número que identifica al producto en la base de datos
     *
     * @since 1.0
     */
    private int id_producto;

    /**
     * Número que identidfica el negocio al que pertenece el producto en la base de datos
     *
     * @since 1.0
     */
    private int id_negocio;

    /**
     * Nombre del producto
     *
     * @since 1.0
     */
    private String nombre;

    /**
     * Precio del producto
     *
     * @since 1.0
     */
    private double precio;

    /**
     * Descripción del producto
     *
     * @since 1.0
     */
    private String descripcion;


    private int stock;

    /**
     * Número que identifica a la imagen del producto en la base de datos
     *
     * @since 1.0
     */
    private int id_img;

    
    private String url_imagen;

    public Producto() {
    }
    public Producto(int id_negocio, String nombre, double precio, String descripcion, int stock) {
        this.id_negocio = id_negocio;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
    }

    public int getId_img() {
        return id_img;
    }

    public void setId_img(int id_img) {
        this.id_img = id_img;
    }





    public Producto(int id_negocio) {
        this.id_negocio = id_negocio;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_negocio() {
        return id_negocio;
    }

    public void setId_negocio(int id_negocio) {
        this.id_negocio = id_negocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public String getJSON(){
       return new Gson().toJson(this);
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }
}
