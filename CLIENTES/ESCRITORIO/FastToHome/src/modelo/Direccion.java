/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.google.gson.Gson;

/**
 * Clase que representa una dirección
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 * @since 1.0
 */
public class Direccion {
    
    /**
     * Número que identifica una direccíón en la base de datos
     * 
     * @since 1.0
     */
    private int id_direccion;
    
    /**
     * Nombre de la calle
     * 
     * @since 1.0
     */
    private String calle;
    
    /**
     * Número de la vivienda o negocio
     * 
     * @since 1.0
     */
    private int numero;
    
    /**
     * Nombre de la ciudad
     * 
     * @since 1.0
     */
    private String ciudad;
    
    /**
     * Otros datos de la dirección
     * 
     * @since 1.0
     */
    private String otros;
    
    /**
     * Codigo postal
     * 
     * @since 1.0
     */
    private int codigo_postal;
    
    
    private int coordenadas;
    
    /**
     * Dirección valida 
     */
    private boolean valida;
    
    public Direccion(int id_direccion, String calle, int numero, String ciudad, String otros, int codigo_postal, int coordenadas) {
        this.id_direccion = id_direccion;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.otros = otros;
        this.codigo_postal = codigo_postal;
        this.coordenadas = coordenadas;
    }

    public Direccion(String calle, int numero, String ciudad, String otros, int codigo_postal, int coordenadas) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.otros = otros;
        this.codigo_postal = codigo_postal;
        this.coordenadas = coordenadas;
    }

    public Direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public Direccion() {
        this.valida = false;
    }

    public boolean isValida() {
        return valida;
    }

    public void setValida(boolean valida) {
        this.valida = valida;
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

    public int getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(int coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getJSON() {
        return new Gson().toJson(this);
    }
}
