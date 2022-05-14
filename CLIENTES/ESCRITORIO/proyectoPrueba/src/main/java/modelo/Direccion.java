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
public class Direccion {
   private int id_direccion;
   private String Direccion;
   private String otros;
   private String coordenads;

    public Direccion() {
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public String getCoordenads() {
        return coordenads;
    }

    public void setCoordenads(String coordenads) {
        this.coordenads = coordenads;
    }

    public Direccion(int id_direccion, String Direccion, String otros, String coordenads) {
        this.id_direccion = id_direccion;
        this.Direccion = Direccion;
        this.otros = otros;
        this.coordenads = coordenads;
    }

}