/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.donoso.proyectoprueba;

import static controlador.gestion.hacerConsulta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Peticion;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author jmcbg
 */
public class principal {

    public static void main(String[] args) throws IOException {

        List<NameValuePair> params = new ArrayList<NameValuePair>();

        
        params.add(new BasicNameValuePair("DATA", new Peticion("prueba", null).getJSON()));
      

        hacerConsulta("http://localhost/php/webService/api.php", params);
    }

}
