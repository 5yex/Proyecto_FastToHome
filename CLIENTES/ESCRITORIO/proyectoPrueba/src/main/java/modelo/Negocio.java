/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jmcbg
 */
public class Negocio {
    private int id_negocio;
    private int id_direccion;
    private int id_categoria;
    private int id_mercadeer;
    private String nombre;
    private String descripcion;

    public Negocio() {
    }

    public Negocio(int id_negocio, int id_direccion, int id_categoria, int id_mercadeer, String nombre, String descripcion) {
        this.id_negocio = id_negocio;
        this.id_direccion = id_direccion;
        this.id_categoria = id_categoria;
        this.id_mercadeer = id_mercadeer;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    
}
