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
   private String calle;
   private int numero;
   private String ciudad;
   private String otros;
   private int codigo_postal;
   private int coordenads;

    public Direccion(int id_direccion, String calle, int numero, String ciudad, String otros, int codigo_postal, int coordenads) {
        this.id_direccion = id_direccion;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.otros = otros;
        this.codigo_postal = codigo_postal;
        this.coordenads = coordenads;
    }

    public Direccion(String calle, int numero, String ciudad, String otros, int codigo_postal, int coordenads) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.otros = otros;
        this.codigo_postal = codigo_postal;
        this.coordenads = coordenads;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public int getCoordenads() {
        return coordenads;
    }

    public void setCoordenads(int coordenads) {
        this.coordenads = coordenads;
    }
   
   public String getJSON(){
       return new Gson().toJson(this);
    }
}