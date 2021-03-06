/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.fasttohome.modelo;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jmcbg
 */
public class Imagen {

    private int id;
    private String b64_imagen;
    private String url_imagen;

    public Imagen() {
    }

    public Imagen(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getB64_imagen() {
        return b64_imagen;
    }

    public void setB64_imagen(String b64_imagen) {
        this.b64_imagen = b64_imagen;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }

  

  
 
    
    public String getJSON() {
        return new Gson().toJson(this);
    }

}
