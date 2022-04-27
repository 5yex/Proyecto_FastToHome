/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author 5yex
 */
public class solicitud {

    int id;
    Enum tipo_solicitud;
    int id_cliente;
    LocalDate fecha;
    int id_instalacion;
    int id_contrato;
    String mensaje;
    Boolean resuelta;
    String motivo_rechazo;

    @Override
    public String toString() {
        return "solicitud{" + "id=" + id + ", tipo_solicitud=" + tipo_solicitud + ", id_cliente=" + id_cliente + ", fecha=" + fecha + ", id_instalacion=" + id_instalacion + ", id_contrato=" + id_contrato + ", mensaje=" + mensaje + ", resuelta=" + resuelta + ", motivo_rechazo=" + motivo_rechazo + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enum getTipo_solicitud() {
        return tipo_solicitud;
    }

    public void setTipo_solicitud(Enum tipo_solicitud) {
        this.tipo_solicitud = tipo_solicitud;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getId_instalacion() {
        return id_instalacion;
    }

    public void setId_instalacion(int id_instalacion) {
        this.id_instalacion = id_instalacion;
    }

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Boolean getResuelta() {
        return resuelta;
    }

    public void setResuelta(Boolean resuelta) {
        this.resuelta = resuelta;
    }

    public String getMotivo_rechazo() {
        return motivo_rechazo;
    }

    public void setMotivo_rechazo(String motivo_rechazo) {
        this.motivo_rechazo = motivo_rechazo;
    }

    public solicitud() {
    }

    public enum tipo_solicitud {
        Instalacion, Asistencia, Cancelacion
    }
}
