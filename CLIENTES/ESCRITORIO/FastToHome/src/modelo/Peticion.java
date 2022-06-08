/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.google.gson.Gson;

/**
 * Clase que representa una petición que se realiza al servicio web
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 * @since 1.0
 */
public class Peticion {
    
    /**
     * Cadena con la acción a realizar por parte del servicio web
     * 
     * @since 1.0
     */
    String comando;
    
    /**
     * Cadena con los datos necesarios para hacer la acción en el servicio web
     * 
     * @since 1.0
     */
    String datos;
    
    /**
     * Construye una Peticion con los parámetros indicados
     * 
     * @param comando Acción a realizar por parte del servicio web
     * @param datos Datos necesarios para hacer la acción en el servicio web
     */
    public Peticion(String comando, String datos) {
        this.comando = comando;
        this.datos = datos;
    }
    
    /**
     * Devuelve el comando con la acción a realizar por parte del servicio web
     * 
     * @return Comando con la acción a realizar por parte del servicio web
     * @since 1.0
     */
    public String getComando() {
        return comando;
    }
    
    /**
     * Establece el comando con la acción a realizar por parte del servicio web
     * 
     * @param comando Comando con la acción a realizar por parte del servicio web
     * @since 1.0
     */
    public void setComando(String comando) {
        this.comando = comando;
    }
    
    /**
     * Devuelve los datos necesarios para hacer la acción en el servicio web
     * 
     * @return Los datos necesarios para hacer la acción en el servicio web
     * @since 1.0
     */
    public String getDatos() {
        return datos;
    }
    
    /**
     * Establece los datos necesarios para hacer la acción en el servicio web
     * 
     * @param datos Los datos necesarios para hacer la acción en el servicio web
     * @since 1.0
     */
    public void setDatos(String datos) {
        this.datos = datos;
    }
    
    /**
     * Devuelve una cadena con los atributos del objeto de tipo Peticion
     * 
     * @return Una cadena con los atributos del objeto de tipo Peticion
     * @since 1.0
     */
    @Override
    public String toString() {
        return "Peticion{" + "comando=" + comando + ", datos=" + datos + '}';
    }
    
    public String getJSON(){
       return new Gson().toJson(this);
    }
    
}
