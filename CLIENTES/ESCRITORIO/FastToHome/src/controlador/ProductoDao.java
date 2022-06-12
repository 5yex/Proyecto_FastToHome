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
 * Clase donde se realizan las consultas realicionadas con los productos
 *
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 * @since 1.0
 */
public class ProductoDao {

    /**
     * Inserta un nuevo producto en la base de datos y comprueba si se ha
     * insertado
     *
     * @param product objeto de tipo Producto con los datos del producto a
     * insertar
     * @return true si se ha insertado el el producto corretamente, false en
     * caso contrario
     */
    public static boolean nuevoProducto(Producto product) {
        return gestion.hacerConsulta(new Peticion("nuevo_producto", product.getJSON()));
    }

    /**
     * Realiza la consulta para devolver una lista con los productos de un
     * negocio
     *
     * @param negocio objeto de tipo Negocio con los datos del negocio
     * @return Una lista con los productos de un negocio
     */
    public static ArrayList<Producto> seleccionProductosNegocio(Negocio negocio) {
        JsonArray jsonArray = gestion.consultaSeleccion(new Peticion("obtener_productos_negocio", negocio.getJSON()));
        ArrayList<Producto> listaProductos = new ArrayList<>();
        System.out.println("controlador.ProductoDao.selecciónProductosNegocio()     NUMERO PRODUCTOS: " + listaProductos.size());
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
            System.out.println("controlador.ProductoDao.selecciónProductosNegocio()     NUMERO PRODUCTOS: " + listaProductos.size());
        }

        return listaProductos;
    }

    /**
     * Actualiza el producto en la base de datos y comprueba si se ha
     * actualizado correctamente
     *
     * @param product objeto de tipo Producto con los datos del producto a
     * actualizar
     * @return true si se ha actualizado el producto en la base de datos
     */
    public static boolean actualizarProducto(Producto product) {
        return gestion.hacerConsulta(new Peticion("actualizar_producto", product.getJSON()));
    }

    /**
     * Borra un producto en la base datos y comprueba si se ha borrado
     * correctamente
     *
     * @param product objeto de tipo Producto con los datos del producto a
     * borrar
     * @return true si se ha borrado el producto en la base de datos, false en
     * caso contrario
     */
    public static boolean borrarProducto(Producto product) {
        return gestion.hacerConsulta(new Peticion("borrar_producto", product.getJSON()));
    }

    public static Producto obtenerProductoPorId(Producto product) {
        String json = product.getJSON();
        //hacemos una petición con el comando que deberá realizar el php, y los datos en json    
        Peticion peticion = new Peticion("obtener_datos_producto", json);
        //mandamos la peticion como consulta selección para obtener valores
        JsonObject productoJson = gestion.consultaSeleccionUnico(peticion);
        Producto producto = new Producto();
        producto.setId_producto(productoJson.get("id").getAsInt());
        producto.setNombre(productoJson.get("Nombre").getAsString());
        producto.setPrecio(Double.valueOf(productoJson.get("Precio").getAsString()));
        producto.setDescripcion(productoJson.get("Descripcion").getAsString());
        producto.setStock(productoJson.get("Stock").getAsInt());
        if (!productoJson.get("imagenes_id").isJsonNull()) {
            producto.setId_img(productoJson.get("imagenes_id").getAsInt());
        }
        return producto;

    }

}
