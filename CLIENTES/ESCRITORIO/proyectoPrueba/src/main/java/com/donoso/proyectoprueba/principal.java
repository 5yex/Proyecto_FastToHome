/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.donoso.proyectoprueba;

import controlador.UsuarioDao;
import controlador.gestion;
import static controlador.gestion.hacerConsulta;
import java.io.IOException;
import modelo.Categoria;
import modelo.Peticion;
import modelo.Producto;
import modelo.Usuario;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author jmcbg
 */
public class principal {

    public static void main(String[] args) throws IOException {

        Usuario user = new Usuario("11");
        //user.setDni("12345678D");
        /*user.setEmail("fasdfa");
        user.setId_direccion(0);
        user.setNombre("paco");
        user.setPassword("pruebas");
        user.setRol("clientes");
        user.setTlf("654789211");*/

 /*Producto producto = new Producto();
        producto.setId_negocio(1);
        producto.setNombre("Manzana");
        producto.setPrecio(3.40);
        producto.setDescripcion("Manzana roja de la huerta");
        producto.setStock(20);*/
        //System.out.println(hacerConsulta(new Peticion("nuevo_usuario", user.getJSON())));
        //System.out.println(hacerConsulta(new Peticion("nuevo_producto", producto.getJSON())));
        //System.out.println(UsuarioDao.obtenerIdCliente(user));
        if (BCrypt.checkpw("PACO", "$2a$10$jIukrdC3Om1/OXSCfVmUl.9SToQjOzL48AgdPYcfTbqmFRHNrfHTS")) {
            System.out.println("LA CONTRASEÑA SE HA GENERADO CORRECTAMENTE Wey");
        }
        if (BCrypt.checkpw("PACO", "$2a$10$7pPIorywzYnthCFpvoPuHuNtN997fkmbJTlS/LfEnCIv48BtmJ7Hm")) {
            System.out.println("LA CONTRASEÑA SE HA GENERADO CORRECTAMENTE Wey");
        }
        if (BCrypt.checkpw("PACO", "$2a$10$36VUzMqDJ9F/8j7n32pcPOoCW2UAh.23uESbHDYowyv7kClLa25/C")) {
            System.out.println("LA CONTRASEÑA SE HA GENERADO CORRECTAMENTE Wey");
        }
        if (BCrypt.checkpw("PACO", "$2a$10$uv1n0lPuPv1V7/C/6wdn..y7v2SPiKMEN15iIbHS/WYnAlTWa6rIG")) {
            System.out.println("LA CONTRASEÑA SE HA GENERADO CORRECTAMENTE Wey");
        }
    }

}
