/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.fasttohome.modelo;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Clase que representa una categoria de un negocio
 *
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 * @since 1.0
 */
public class Categoria implements Serializable {

    /**
     * Numero identificador de la categorira en la base de datos
     *
     * @since 1.0
     */
    private int id;

    /**
     * Nombre o título de la categoria
     *
     * @since 1.0
     */
    private String nombre;

    /**
     * Construye una Categoria con atributos a <code>null</code>
     *
     * @since 1.0
     */
    public Categoria() {
    }

    /**
     * Construye una Categoria con los parámetros indicados
     *
     * @param id Número que identifica a la categoria
     * @param nombre Nombre de la categoria
     */
    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Construye una Categoria con los parámetros indicados
     *
     * @param nombre Nombre de la categoria
     */
    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el número que identifica a la categoria en la base de datos
     *
     * @return número que identidica a la categoria en la base de datos
     * @since 1.0
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el número que identifica a la categoria en la base de datos
     *
     * @param id Número que identifica a la categoria en la base de datos
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre de la categoria
     *
     * @return nombre de la categoria
     * @since 1.0
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la categoria
     *
     * @param nombre Nombre de la categoria
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el objeto de tipo Categoria en forma de JSon
     *
     * @return el objeto de tipo Categoria en forma de JSon
     */
    public String getJSON(){
        return new Gson().toJson(this);
    }
}
