/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.fasttohome.modelo;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jmcbg
 */

public class Pedido implements Serializable {
    private int id_pedido;
    private int id_usuario;
    private int id_negocio;
    private String fecha_hora;
    private String estado;
    private double total;
    private String transporte;

    public Pedido() {

    }

    public Pedido(int id_pedido, int id_usuario, int id_negocio, String fecha_hora, String estado, double total, String transporte) {
        this.id_pedido = id_pedido;
        this.id_usuario = id_usuario;
        this.id_negocio = id_negocio;
        this.fecha_hora = fecha_hora;
        this.estado = estado;
        this.total = total;
        this.transporte = transporte;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_negocio() {
        return id_negocio;
    }

    public void setId_negocio(int id_negocio) {
        this.id_negocio = id_negocio;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public String getJSON() {
        return new Gson().toJson(this);
    }
}
