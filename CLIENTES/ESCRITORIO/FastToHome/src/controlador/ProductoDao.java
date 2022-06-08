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
 * obtener_productos_negocio
 */



public class ProductoDao {

    public static boolean nuevoProducto(Producto product) {
        return gestion.hacerConsulta(new Peticion("nuevo_producto", product.getJSON()));
    }

    
    
    public static ArrayList<Producto> selecciónProductosNegocio(Negocio negocio) {
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("obtener_productos_negocio", negocio.getJSON()));
        ArrayList<Producto> listaProductos = new ArrayList<>();
        //System.out.println("controlador.ProductoDao.selecciónProductosNegocio()     NUMERO PRODUCTOS: " + listaProductos.size());
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject productoJson = jsonArray.get(i).getAsJsonObject();
                Producto producto = new Producto();
                producto.setId_producto(productoJson.get("id").getAsInt());
                producto.setNombre(productoJson.get("Nombre").getAsString());
                producto.setPrecio(Double.valueOf(productoJson.get("Precio").getAsString()));
                producto.setDescripcion(productoJson.get("Descripcion").getAsString());
                producto.setStock(productoJson.get("Stock").getAsInt());
                if (!productoJson.get("imagenes_id").isJsonNull()) {
                    producto.setId_img(productoJson.get("imagenes_id").getAsInt());
                }
                listaProductos.add(producto);
            }
            //System.out.println("controlador.ProductoDao.selecciónProductosNegocio()     NUMERO PRODUCTOS: " + listaProductos.size());
        }
        
        return listaProductos;
    }

    public static boolean actualizarProducto(Producto product) {
        return gestion.hacerConsulta(new Peticion("actualizar_producto", product.getJSON()));
    }

    public static boolean borrarProducto(Producto product) {
        return gestion.hacerConsulta(new Peticion("borrar_producto", product.getJSON()));
    }

}
