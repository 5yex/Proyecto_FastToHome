/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.Date;
import modelo.Categoria;
import modelo.Imagen;
import modelo.Peticion;

/**
 *
 * @author jmcbg
 */
public class ImagenDao {
    public static boolean nuevaImagen(Imagen imagen) {
        imagen.setUrl_imagen("imagenes/"+new Date(System.currentTimeMillis())+".png");
        return gestion.hacerConsulta(new Peticion("nueva_imagen", imagen.getJSON()));
    }
}
