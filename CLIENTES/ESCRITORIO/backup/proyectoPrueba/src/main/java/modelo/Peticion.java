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
public class Peticion {
    String comando;
    String datos;

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public Peticion(String comando, String datos) {
        this.comando = comando;
        this.datos = datos;
    }

    @Override
    public String toString() {
        return "Peticion{" + "comando=" + comando + ", datos=" + datos + '}';
    }
    
    public String getJSON(){
       return new Gson().toJson(this);
    }
    
}
