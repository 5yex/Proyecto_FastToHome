/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.google.gson.Gson;
import java.util.Date;

/**
 * Clase que representa un pedido realizado por un usuario
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 * @since 1.0
 */
public class Pedido {
    
    /**
     * Número que identifica el pedido en la base de datos
     * 
     * @since 1.0
     */
    private int id_pedido;
    
    /**
     * Número que identidica al usuario que ha realizado el pedido en la base de datos
     * 
     * @since 1.0
     */
    private int id_usuario;
    
    /**
     * Número que identidfica el negocio donde se ha realizado el pedido en la base de datos
     * 
     * @since 1.0
     */
    private int id_negocio;
    
    /**
     * Fecha y hora del pedido
     * 
     * @since 1.0
     */
    private Date fecha_hora;
    
    /**
     * Estado en el que se encuentra el pedido
     * 
     * @since 1.0
     */
    private String estado;
    
    /**
     * Total de dinero pagado
     * 
     * @since 1.0
     */
    private double total;
    
    /**
     * Forma de transporte del pedido
     * 
     * @since 1.0
     */
    private String transporte;
    
    /**
     * Construye un Pedido con parametros a <code>null</code>
     * 
     * @since 1.0
     */
    public Pedido() {
    }
    
    /**
     * Construye un Pedido con los parametros indicados
     * 
     * @param id_pedido Número que identifica el pedido en la base de datos
     * @param id_usuario Número que identidica al usuario que ha realizado el pedido en la base de datos
     * @param id_negocio Número que identidfica el negocio donde se ha realizado el pedido en la base de datos
     * @param fecha_hora Fecha y hora del pedido
     * @param estado Estado en el que se encuentra el pedido
     * @param total Total de dinero pagado
     * @param transporte Forma de transporte del pedido
     */
    public Pedido(int id_pedido, int id_usuario, int id_negocio, Date fecha_hora, String estado, double total, String transporte) {
        this.id_pedido = id_pedido;
        this.id_usuario = id_usuario;
        this.id_negocio = id_negocio;
        this.fecha_hora = fecha_hora;
        this.estado = estado;
        this.total = total;
        this.transporte = transporte;
    }
    
    /**
     * Construye un Pedido con los parametros indicados
     * 
     * @param id_usuario Número que identidica al usuario que ha realizado el pedido en la base de datos
     * @param id_negocio Número que identidfica el negocio donde se ha realizado el pedido en la base de datos
     * @param fecha_hora Fecha y hora del pedido
     * @param estado Estado en el que se encuentra el pedido
     * @param total Total de dinero pagado
     * @param transporte Forma de transporte del pedido
     */
    public Pedido(int id_usuario, int id_negocio, Date fecha_hora, String estado, double total, String transporte) {
        this.id_usuario = id_usuario;
        this.id_negocio = id_negocio;
        this.fecha_hora = fecha_hora;
        this.estado = estado;
        this.total = total;
        this.transporte = transporte;
    }
    
    /**
     * Devuelve el número que identifica el pedido en la base de datos
     * 
     * @return Número que identifica el pedido en la base de datos
     * @since 1.0
     */
    public int getId_pedido() {
        return id_pedido;
    } 
    
    /**
     * Establece el número que identifica el pedido en la base de datos
     * 
     * @param id_pedido Número que identifica el pedido en la base de datos 
     */
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

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
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
    
    public String getJSON(){
       return new Gson().toJson(this);
    }
    
    public Object[] getRow() {
        return new Object[]{id_pedido, id_usuario, transporte, total, fecha_hora, estado};
    }

    @Override
    public String toString() {
        return "Pedido{" + "id_pedido=" + id_pedido + ", id_usuario=" + id_usuario + ", id_negocio=" + id_negocio + ", fecha_hora=" + fecha_hora + ", estado=" + estado + ", total=" + total + ", transporte=" + transporte + '}';
    }
    
    
    
}
