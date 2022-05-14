package controlador;

import modelo.Negocio;
import modelo.Peticion;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jmcbg
 */
public class NegocioDao {
    
     public boolean nuevoProducto(Negocio negocio){
        return gestion.hacerConsulta(new Peticion("nuevo_producto", negocio.getJSON()));
    }
    
    
    
}
