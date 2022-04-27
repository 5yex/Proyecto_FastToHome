/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author 5yex
 */
public class tarifa {
    int id;
    int precio;
    boolean permanencia;
    String velocidad;

    public tarifa(int id, int precio, boolean permanencia, String velocidad) {
        this.id = id;
        this.precio = precio;
        this.permanencia = permanencia;
        this.velocidad = velocidad;
    }

    public tarifa(int id) {
        this.id = id;
    }

    public tarifa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isPermanencia() {
        return permanencia;
    }

    public void setPermanencia(boolean permanencia) {
        this.permanencia = permanencia;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }
    
}
