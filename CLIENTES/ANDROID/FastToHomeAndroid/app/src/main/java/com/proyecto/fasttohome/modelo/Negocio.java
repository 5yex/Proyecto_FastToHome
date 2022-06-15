/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.fasttohome.modelo;

import android.graphics.Bitmap;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Clase que representa un negocio
 *
 * @author Jose Miguel Calderón, Jesús Rueda Tena
 * @version 1.0
 * @since 1.0
 */
public class Negocio implements Serializable {
    /**
     * Número que identifica un negocio en la base de datos
     *
     * @since 1.0
     */
    private int id_negocio;

    /**
     * Número que identifica la dirección del negocio en la base de datos
     *
     * @since 1.0
     */
    private int id_direccion;

    /**
     * Número que identifica la categoría del negocio en la base de datos
     *
     * @since 1.0
     */
    private int id_categoria;

    /**
     * Número que identifica al propietario del negocio en la base de datos
     *
     * @since 1.0
     */
    private int id_mercader;

    /**
     * Nombre del negocio
     *
     * @since 1.0
     */
    private String nombre;

    /**
     * Descripción del negocio
     *
     * @since 1.0
     */
    private String descripcion;

    /**
     * Número que identifica la imagen asociada al negocio en la base de datos
     *
     * @since 1.0
     */
    private int id_img;
    private String url_imagen;

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }

    /**
     * Construye un negocio con parametros a <code>null</code>
     *
     * @since 1.0
     */
    public Negocio() {
    }

    /**
     * Construye un negocio con los parametros indicados
     *
     * @param id_negocio Número que identifica un negocio en la base de datos
     * @param id_direccion Número que identifica la dirección del negocio en la base de datos
     * @param id_categoria Número que identifica la categoría del negocio en la base de datos
     * @param id_mercader Número que identifica al propietario del negocio en la base de datos
     * @param nombre Nombre del negocio
     * @param descripcion Descripción del negocio
     * @param id_img Número que identifica la imagen asociada al negocio en la base de datos
     */
    public Negocio(int id_negocio, int id_direccion, int id_categoria, int id_mercader, String nombre, String descripcion, int id_img) {
        this.id_negocio = id_negocio;
        this.id_direccion = id_direccion;
        this.id_categoria = id_categoria;
        this.id_mercader = id_mercader;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id_img = id_img;
    }

    /**
     * Construye un negocio con los parametros indicados
     *
     * @param id_direccion Número que identifica la dirección del negocio en la base de datos
     * @param id_categoria Número que identifica la categoría del negocio en la base de datos
     * @param id_mercader Número que identifica al propietario del negocio en la base de datos
     * @param nombre Nombre del negocio
     * @param descripcion Descripción del negocio
     * @param id_img Número que identifica la imagen asociada al negocio en la base de datos
     */
    public Negocio(int id_direccion, int id_categoria, int id_mercader, String nombre, String descripcion, int id_img) {
        this.id_direccion = id_direccion;
        this.id_categoria = id_categoria;
        this.id_mercader = id_mercader;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id_img = id_img;
    }

    /**
     * Construye un negocio con los parametros indicados
     *
     * @param id_direccion Número que identifica la dirección del negocio en la base de datos
     * @param id_categoria Número que identifica la categoría del negocio en la base de datos
     * @param id_mercader Número que identifica al propietario del negocio en la base de datos
     * @param nombre Nombre del negocio
     * @param descripcion Descripción del negocio
     */
    public Negocio(int id_direccion, int id_categoria, int id_mercader, String nombre, String descripcion) {
        this.id_direccion = id_direccion;
        this.id_categoria = id_categoria;
        this.id_mercader = id_mercader;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * Construye un negocio con los parametros indicados
     *
     * @param id_negocio Número que identifica un negocio en la base de datos
     */
    public Negocio(int id_negocio) {
        this.id_negocio = id_negocio;
    }

    /**
     * Devuelve el número que identifica un negocio en la base de datos
     *
     * @return Número que identifica un negocio en la base de datos
     * @since 1.0
     */
    public int getId_negocio() {
        return id_negocio;
    }

    /**
     * Establece el número que identifica un negocio en la base de datos
     *
     * @param id_negocio Número que identifica un negocio en la base de datos
     * @since 1.0
     */
    public void setId_negocio(int id_negocio) {
        this.id_negocio = id_negocio;
    }

    /**
     * Devuelve el número que identifica la dirección del negocio en la base de datos
     *
     * @return Número que identifica la dirección del negocio en la base de datos
     * @since 1.0
     */
    public int getId_direccion() {
        return id_direccion;
    }

    /**
     * Establece el número que identifica la dirección del negocio en la base de datos
     *
     * @param id_direccion Número que identifica la dirección del negocio en la base de datos
     * @since 1.0
     */
    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    /**
     * Devuelve el número que identifica la categoría del negocio en la base de datos
     *
     * @return Número que identifica la categoría del negocio en la base de datos
     * @since 1.0
     */
    public int getId_categoria() {
        return id_categoria;
    }

    /**
     * Establece el número que identifica la categoría del negocio en la base de datos
     *
     * @param id_categoria Número que identifica la categoría del negocio en la base de datos
     * @since 1.0
     */
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    /**
     * Devuelve el número que identifica al propietario del negocio en la base de datos
     *
     * @return Número que identifica al propietario del negocio en la base de datos
     * @since 1.0
     */
    public int getId_mercader() {
        return id_mercader;
    }

    /**
     * Establece el número que identifica al propietario del negocio en la base de datos
     *
     * @param id_mercader Número que identifica al propietario del negocio en la base de datos
     * @since 1.0
     */
    public void setId_mercader(int id_mercader) {
        this.id_mercader = id_mercader;
    }

    /**
     * Devuelve el nombre del negocio
     *
     * @return Nombre del negocio
     * @since 1.0
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del negocio
     *
     * @param nombre Nombre del negocio
     * @since 1.0
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la descripción del negocio
     *
     * @return Descripción del negocio
     * @since 1.0
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del negocio
     *
     * @param descripcion Descripción del negocio
     * @since 1.0
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el número que identifica la imagen asociada al negocio en la base de datos
     *
     * @return Número que identifica la imagen asociada al negocio en la base de datos
     * @since 1.0
     */
    public int getId_img() {
        return id_img;
    }

    /**
     * Establece el número que identifica la imagen asociada al negocio en la base de datos
     *
     * @param id_img Número que identifica la imagen asociada al negocio en la base de datos
     * @since 1.0
     */
    public void setId_img(int id_img) {
        this.id_img = id_img;
    }

    /**
     * Devuelve el objeto de tipo Negocio en forma de JSon
     *
     * @return el objeto de tipo Negocio en forma de JSon
     * @since 1.0
     */
    public String getJSON(){
        return new Gson().toJson(this);
    }
    
    
}
