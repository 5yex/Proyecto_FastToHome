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
     * Número que identifica al usuario que ha realizado el pedido en la base de datos
     * 
     * @since 1.0
     */
    private int id_usuario;
    
    /**
     * Número que identifica el negocio donde se ha realizado el pedido en la base de datos
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
     * @param id_usuario Número que identifica al usuario que ha realizado el pedido en la base de datos
     * @param id_negocio Número que identifica el negocio donde se ha realizado el pedido en la base de datos
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
     * @param id_usuario Número que identifica al usuario que ha realizado el pedido en la base de datos
     * @param id_negocio Número que identifica el negocio donde se ha realizado el pedido en la base de datos
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
     * @since 1.0
     */
    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }
    
    /**
     * Devuelve el número que identifica el usuario donde se ha realizado el pedido en la base de datos
     * 
     * @return Número que identifica el usuario donde se ha realizado el pedido en la base de datos
     * @since 1.0
     */
    public int getId_usuario() {
        return id_usuario;
    }
    
    /**
     * Establece el Número que identifica el usuario donde se ha realizado el pedido en la base de datos
     * 
     * @param id_usuario Número que identifica el usuario donde se ha realizado el pedido en la base de datos
     * @since 1.0
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    /**
     * Devuelve el número que identifica el negocio donde se ha realizado el pedido en la base de datos
     * 
     * @return Número que identifica el negocio donde se ha realizado el pedido en la base de datos
     * @since 1.0
     */
    public int getId_negocio() {
        return id_negocio;
    }
    
    /**
     * Establece el número que identifica el negocio donde se ha realizado el pedido en la base de datos
     * 
     * @param id_negocio Número que identifica el negocio donde se ha realizado el pedido en la base de datos
     * @since 1.0
     */
    public void setId_negocio(int id_negocio) {
        this.id_negocio = id_negocio;
    }
    
    /**
     * Devuelve la fecha y hora del pedido
     * 
     * @return Fecha y hora del pedido 
     * @since 1.0
     */
    public Date getFecha_hora() {
        return fecha_hora;
    }
    
    /**
     * Establece la fecha y hora del pedido
     * @param fecha_hora Fecha y hora del pedido
     * @since 1.0
     */
    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }
    
    /**
     * Devuelve el estado en el que se encuentra el pedido
     * 
     * @return Estado en el que se encuentra el pedido
     * @since 1.0
     */
    public String getEstado() {
        return estado;
    }
    
    /**
     * Establece el estado en el que se encuentra el pedido
     * 
     * @param estado Estado en el que se encuentra el pedido
     * @since 1.0
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    /**
     * Devuelve el total de dinero pagado
     * 
     * @return Total de dinero pagado
     * @since 1.0
     */
    public double getTotal() {
        return total;
    }
    
    /**
     * Establece el total de dinero pagado
     * 
     * @param total Total de dinero pagado
     * @since 1.0
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    /**
     * Devuelve la forma de transporte del pedido
     * 
     * @return Forma de transporte del pedido
     * @since 1.0
     */
    public String getTransporte() {
        return transporte;
    }
    
    /**
     * Establece la forma de transporte del pedido
     * 
     * @param transporte Forma de transporte del pedido
     * @since 1.0
     */
    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }
    
    /**
     * Devuelve el objeto de tipo Usuario en forma de JSon
     * 
     * @return el objeto de tipo Categoria en forma de JSon
     * @since 1.0
     */
    public String getJSON(){
       return new Gson().toJson(this);
    }
    
    /**
     * Devuelve una cadena con los atributos del objeto de tipo Pedido
     *
     * @return Cadena con los atributos del objeto de tipo Pedido
     * @since 1.0
     */
    @Override
    public String toString() {
        return "Pedido{" + "id_pedido=" + id_pedido + ", id_usuario=" + id_usuario + ", id_negocio=" + id_negocio + ", fecha_hora=" + fecha_hora + ", estado=" + estado + ", total=" + total + ", transporte=" + transporte + '}';
    }
    
    
    
}
