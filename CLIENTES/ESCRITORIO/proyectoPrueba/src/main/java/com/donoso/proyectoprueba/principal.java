/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.donoso.proyectoprueba;

import com.formdev.flatlaf.FlatDarkLaf;
import controlador.UsuarioDao;
import controlador.gestion;
import static controlador.gestion.hacerConsulta;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.JMarsDarkTheme;
import mdlaf.themes.MaterialLiteTheme;
import mdlaf.themes.MaterialOceanicTheme;
import mdlaf.themes.MaterialTheme;
import modelo.Categoria;
import modelo.Peticion;
import modelo.Producto;
import modelo.Usuario;
import vista.FrameLogin;

/**
 *
 * @author jmcbg
 */
public class principal {
public static FrameLogin lg;
    public static void main(String[] args) throws IOException, UnsupportedLookAndFeelException {

        // Usuario user = new Usuario("11");
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
        
        UIManager.setLookAndFeel(new MaterialLookAndFeel(new JMarsDarkTheme()));
        lg = new FrameLogin();
        lg.setVisible(true);

    }

}
