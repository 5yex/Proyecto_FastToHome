/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author jmcbg
 */
public class imagenesUtil {
    public static String imagenABase64(File imagenFile){
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
    
    
    public static String base64AImagen(File imagenFile){
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
    
    
}
