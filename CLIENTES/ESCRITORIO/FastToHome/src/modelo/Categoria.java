/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.google.gson.Gson;

/**
 * Clase que representa una categoria de un negocio
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 * @since 1.0
 */
public class Categoria {
    
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

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getJSON(){
       return new Gson().toJson(this);
    }
}
