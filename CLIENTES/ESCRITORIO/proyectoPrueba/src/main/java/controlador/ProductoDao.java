

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
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
    
    public ArrayList <Producto> selecciónProductosNegocio(Producto negocio){
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("obtener_usuarios", negocio.getJSON()));
        
        Producto producto;
        
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject productoJson = jsonArray.get(i).getAsJsonObject();
            
            negocio.setId_producto(productoJson.get("id").getAsInt());
            negocio.setNombre(productoJson.get("Nombre").getAsString());
            negocio.setPrecio(productoJson.get("Precio").getAsDouble());
            negocio.setDescripcion(productoJson.get("Descripcion").getAsString());
            negocio.setStock(productoJson.get("Stock").getAsInt());
            
            listaProductos.add(negocio);

        }
        return listaProductos;
    }
}
