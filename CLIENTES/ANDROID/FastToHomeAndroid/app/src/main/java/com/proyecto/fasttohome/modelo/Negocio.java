/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.fasttohome.modelo;

import android.graphics.Bitmap;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 *
 * @author jmcbg
 */
public class Negocio implements Serializable {
    private int id_negocio;
    private int id_direccion;
    private int id_categoria;
    private int id_mercader;
    private String nombre;
    private String descripcion;
    private int id_img;
    private Bitmap image;

    public Negocio() {
    }

    public Negocio(int id_negocio, String nombre, String descripcion) {
        this.id_negocio = id_negocio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Negocio(int id_negocio, int id_direccion, int id_categoria, int id_mercader, String nombre, String descripcion, int id_img) {
        this.id_negocio = id_negocio;
        this.id_direccion = id_direccion;
        this.id_categoria = id_categoria;
        this.id_mercader = id_mercader;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id_img = id_img;
    }

    public Negocio(int id_direccion, int id_categoria, int id_mercader, String nombre, String descripcion, int id_img) {
        this.id_direccion = id_direccion;
        this.id_categoria = id_categoria;
        this.id_mercader = id_mercader;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id_img = id_img;
    }

    public Negocio(int id_direccion, int id_categoria, int id_mercader, String nombre, String descripcion) {
        this.id_direccion = id_direccion;
        this.id_categoria = id_categoria;
        this.id_mercader = id_mercader;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    
    
    public Negocio(int id_negocio) {
        this.id_negocio = id_negocio;
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

    public int getId_mercader() {
        return id_mercader;
    }

    public void setId_mercader(int id_mercader) {
        this.id_mercader = id_mercader;
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

    public int getId_img() {
        return id_img;
    }

    public void setId_img(int id_img) {
        this.id_img = id_img;
    }
    
    public String getJSON(){
       return new Gson().toJson(this);
    }
    
    
}
