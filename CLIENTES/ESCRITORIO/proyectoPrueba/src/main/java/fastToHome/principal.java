/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package fastToHome;

import com.formdev.flatlaf.FlatLightLaf;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        lg = new FrameLogin();
        lg.setVisible(true);
        
       

    }

}
