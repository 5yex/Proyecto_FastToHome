

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import modelo.Negocio;
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
    
    public ArrayList <Producto> selecciónProductosNegocio(Producto product){
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("obtener_usuarios", product.getJSON()));

        ArrayList<Producto> listaProductos = new ArrayList<Producto>();

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject productoJson = jsonArray.get(i).getAsJsonObject();
            
            product.setId_producto(productoJson.get("id").getAsIn);
            product.setNombre(productoJson.get("Nombre").getAsString());
            product.setPrecio(productoJson.get("Precio").getAsDouble());
            product.setDescripcion(productoJson.get("Descripcion").getAsString());
            product.setStock(productoJson.get("Stock").getAsInt());
            
            listaProductos.add(product);

        }
        return listaProductos;
    }
}
