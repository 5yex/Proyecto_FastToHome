/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.google.gson.Gson;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.stream.FileImageInputStream;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author jmcbg
 */
public class Imagen {

    private int id;
    private String imagenB64;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagenB64() {
        return imagenB64;
    }

    public void setImagenB64(String imagenB64) {
        this.imagenB64 = imagenB64;
    }

  
 
    
    public String getJSON() {
        return new Gson().toJson(this);
    }

}
