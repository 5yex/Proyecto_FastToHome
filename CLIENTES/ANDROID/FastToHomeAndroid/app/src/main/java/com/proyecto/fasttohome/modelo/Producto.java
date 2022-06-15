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

    /**
     * Construye un Producto con parametros a <code>null</code>
     *
     * @since 1.0
     */
    public Producto() {
    }

    /**
     * Construye un Producto con los parametros indicados
     *
     * @param id_negocio Número que identidfica el negocio al que pertenece el producto en la base de datos
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param descripcion Descripción del producto
     * @param stock
     */
    public Producto(int id_negocio, String nombre, double precio, String descripcion, int stock) {
        this.id_negocio = id_negocio;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
    }

    /**
     * Construye un Producto con los parametros indicados
     *
     * @param id_producto Número que identifica al producto en la base de datos
     * @param id_negocio Número que identidfica el negocio al que pertenece el producto en la base de datos
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param descripcion Descripción del producto
     * @param stock
     */
    public Producto(int id_producto, int id_negocio, String nombre, double precio, String descripcion, int stock) {
        this.id_producto = id_producto;
        this.id_negocio = id_negocio;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
    }
<<<<<<< HEAD

    public void setId_img(int id_img) {
        this.id_img = id_img;
    }


=======
    /**
     * Construye un Producto con los parametros indicados
     *
     * @param id_negocio Número que identidfica el negocio al que pertenece el producto en la base de datos
     */
>>>>>>> 6d43dc512957afc95bc2bfe7a8d43d56cfbd450e
    public Producto(int id_negocio) {
        this.id_negocio = id_negocio;
    }

    /**
     * Devuelve el número que identifica a la imagen del producto en la base de datos
     *
     * @return Número que identifica a la imagen del producto en la base de datos
     * @since 1.0
     */
    public int getId_img() {
        return id_img;
    }

    /**
     * Establece el número que identifica a la imagen del producto en la base de datos
     *
     * @param id_img Número que identifica a la imagen del producto en la base de datos
     * @since 1.0
     */
    public void setId_img(int id_img) {
        this.id_img = id_img;
    }

    /**
     * Devuelve el número que identifica al producto en la base de datos
     *
     * @return Número que identifica al producto en la base de datos
     * @since 1.0
     */
    public int getId_producto() {
        return id_producto;
    }

    /**
     * Establece el número que identifica al producto en la base de datos
     *
     * @param id_producto Número que identifica al producto en la base de datos
     * @since 1.0
     */
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * Devueve el número que identidfica el negocio al que pertenece el producto en la base de datos
     *
     * @return Número que identidfica el negocio al que pertenece el producto en la base de datos
     * @since 1.0
     */
    public int getId_negocio() {
        return id_negocio;
    }

    /**
     * Establece el número que identidfica el negocio al que pertenece el producto en la base de datos
     *
     * @param id_negocio Número que identidfica el negocio al que pertenece el producto en la base de datos
     * @since 1.0
     */
    public void setId_negocio(int id_negocio) {
        this.id_negocio = id_negocio;
    }

    /**
     * Devuelve el nombre del producto
     *
     * @return Nombre del producto
     * @since 1.0
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto
     *
     * @param nombre Nombre del producto
     * @since 1.0
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el precio del producto
     *
     * @return Precio del producto
     * @since 1.0
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto
     *
     * @param precio Precio del producto
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Devuelve la descripcion de producto
     *
     * @return Descripcion de producto
     * @since 1.0
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripcion de producto
     *
     * @param descripcion Descripcion de producto
     * @since 1.0
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Devuelve el objeto de tipo Usuario en forma de JSon
     *
     * @return el objeto de tipo Categoria en forma de JSon
     * @since 1.0
     */
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
