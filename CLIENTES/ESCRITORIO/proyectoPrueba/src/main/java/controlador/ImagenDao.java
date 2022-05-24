/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalDate;
import java.util.Date;
import javax.swing.ImageIcon;
import modelo.Categoria;
import modelo.Direccion;
import modelo.Imagen;
import modelo.Peticion;

/**
 *
 * @author jmcbg
 */
public class ImagenDao {
    public static boolean nuevaImagen(Imagen imagen) {
        imagen.setUrl_imagen("imagenes/"+new Date().getTime()+".png");
        return gestion.hacerConsulta(new Peticion("nueva_imagen", imagen.getJSON()));
    }
    
    public static int nuevaImagenDevuelveId(Imagen imagen) {
        imagen.setUrl_imagen("imagenes/"+new Date().getTime()+".png");
        return gestion.consultaSeleccionUnico(new Peticion("nueva_imagen", imagen.getJSON())).get("last_id").getAsInt();
    }
    
    public static ImageIcon obtenerImagenPorId(Imagen imagen) {
        String imgB64 = gestion.consultaSeleccionUnico(new Peticion("obtener_imagen_id", imagen.getJSON())).get("last_id").getAsString();
    }
}
