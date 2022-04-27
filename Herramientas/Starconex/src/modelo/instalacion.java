/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author 5yex
 */
public class instalacion {
    int id;
    ArrayList<fechaTexto> estado_instalacion;
    int id_user_instalador;
    LocalDate fecha;
    direccion direccion;

    @Override
    public String toString() {
        return "instalacion{" + "id=" + id + ", estado_instalacion=" + estado_instalacion + ", id_user_instalador=" + id_user_instalador + ", fecha=" + fecha + ", direccion=" + direccion + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<fechaTexto> getEstado_instalacion() {
        return estado_instalacion;
    }

    public void setEstado_instalacion(ArrayList<fechaTexto> estado_instalacion) {
        this.estado_instalacion = estado_instalacion;
    }

    public int getId_user_instalador() {
        return id_user_instalador;
    }

    public void setId_user_instalador(int id_user_instalador) {
        this.id_user_instalador = id_user_instalador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(direccion direccion) {
        this.direccion = direccion;
    }

    public instalacion() {
    }
    
}
