

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Peticion;
import modelo.Producto;

/**
 *
 * @author Jesus
 */
public class ProductoDao {
    public boolean nuevoProducto(Producto product){
        return gestion.hacerConsulta(new Peticion("nuevo_producto", product.getJSON()));
    }
}
