/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.google.gson.Gson;

/**
 *
 * @author jmcbg
 */
public class Negocio {
    private int id_negocio;
    private int id_direccion;
    private int id_categoria;
    private int id_mercader;
    private String nombre;
    private String descripcion;

    public Negocio() {
    }

    public Negocio(int id_negocio, int id_direccion, int id_categoria, int id_mercader, String nombre, String descripcion) {
        this.id_negocio = id_negocio;
        this.id_direccion = id_direccion;
        this.id_categoria = id_categoria;
        this.id_mercader = id_mercader;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Negocio(int id_direccion, int id_categoria, int id_mercader, String nombre, String descripcion) {
        this.id_direccion = id_direccion;
        this.id_categoria = id_categoria;
        this.id_mercader = id_mercader;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId_negocio() {
        return id_negocio;
    }

    public void setId_negocio(int id_negocio) {
        this.id_negocio = id_negocio;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_mercadeer() {
        return id_mercader;
    }

    public void setId_mercadeer(int id_mercadeer) {
        this.id_mercader = id_mercadeer;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getJSON(){
       return new Gson().toJson(this);
    }
    
    
}
