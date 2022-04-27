/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 5yex
 */
public class contrato {

    int id;
    int id_usuario;
    int id_tarifa;
    Date fecha;
    Boolean en_vigor;
    Enum estado_servicio;
    ArrayList<fechaTexto> incidencias;

    public enum estado_servicio {
        Correcto, Corte_por_impago, Incidencia_Temporal, Corte_por_Mantenimiento, Instalacion_Pendiente
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_tarifa() {
        return id_tarifa;
    }

    public void setId_tarifa(int id_tarifa) {
        this.id_tarifa = id_tarifa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getEn_vigor() {
        return en_vigor;
    }

    public void setEn_vigor(Boolean en_vigor) {
        this.en_vigor = en_vigor;
    }

    public Enum getEstado_servicio() {
        return estado_servicio;
    }

    public void setEstado_servicio(Enum estado_servicio) {
        this.estado_servicio = estado_servicio;
    }

    public ArrayList<fechaTexto> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(ArrayList<fechaTexto> incidencias) {
        this.incidencias = incidencias;
    }

    public contrato() {
    }
}
