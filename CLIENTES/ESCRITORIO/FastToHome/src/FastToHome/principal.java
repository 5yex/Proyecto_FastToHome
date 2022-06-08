/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package FastToHome;

import com.formdev.flatlaf.FlatLightLaf;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import vista.FrameLogin;

/**
 * Clase principal desde donde arrancamos la ventana de Logueo
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 */
public class principal {
public static FrameLogin lg;
    public static void main(String[] args) throws IOException, UnsupportedLookAndFeelException {
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        lg = new FrameLogin();
        lg.setVisible(true);
    }

}
