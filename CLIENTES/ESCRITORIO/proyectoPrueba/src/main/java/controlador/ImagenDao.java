/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Categoria;
import modelo.Peticion;

/**
 *
 * @author jmcbg
 */
public class ImagenDao {
     public static boolean nuevoUsuario(Categoria categoria) {
        return gestion.hacerConsulta(new Peticion("nueva_imagen", categoria.getJSON()));
    }
}
