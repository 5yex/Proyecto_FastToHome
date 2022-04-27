/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Timestamp;

/**
 *
 * @author 5yex
 */
public class fechaTexto {
    Timestamp m;
    String d;

    @Override
    public String toString() {
        return "incidencias_detectadas{" + "m=" + m + ", d=" + d + '}';
    }

    public fechaTexto() {
    }

    public Timestamp getM() {
        return m;
    }

    public void setM(Timestamp m) {
        this.m = m;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
}
