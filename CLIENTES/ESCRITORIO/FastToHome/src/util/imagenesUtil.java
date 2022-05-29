/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author jmcbg
 */
public class imagenesUtil {

    public static String imagenABase64(File imagenFile) {
        try {
            byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(imagenFile));
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(imagenesUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(imagenesUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ImageIcon base64AImagen(String imagenBase64) {
        byte[] decodedBytes = Base64.getDecoder().decode(imagenBase64);
        return new ImageIcon(decodedBytes);
    }

    public static void imagenB64Ajlabel(String imgBase64, JLabel label){
        label.setText("");
        try {
            ImageIcon image = imagenesUtil.base64AImagen(imgBase64);
            label.setIcon(new ImageIcon(image.getImage().getScaledInstance(label.getPreferredSize().width, label.getPreferredSize().height, Image.SCALE_SMOOTH)));
            label.setBackground(Color(image.getRGB(0, 0)));
        } catch (Exception e) {
            label.setText("NO IMAGE");
            System.out.println("no tienes icono");
        }
    }
    
    public static void imagenProyectoAjlabel(ImageIcon image, JLabel label){
        label.setText("");
        try {
            label.setIcon(new ImageIcon(image.getImage().getScaledInstance(label.getPreferredSize().width, label.getPreferredSize().height, Image.SCALE_SMOOTH)));
        } catch (Exception e) {
            label.setText("NO IMAGE");
            System.out.println("no tienes icono");
        }
    }
    
    public static void imagenProyectoABttton(ImageIcon image, JButton boton){
        boton.setText("");
        try {
            boton.setIcon(new ImageIcon(image.getImage().getScaledInstance(boton.getPreferredSize().width-2, boton.getPreferredSize().width-2, Image.SCALE_SMOOTH)));
            boton.setBackground(Color(image.getRGB(0, 0));
        } catch (Exception e) {
            System.out.println("no tienes icono");
        }
    }
    
}
