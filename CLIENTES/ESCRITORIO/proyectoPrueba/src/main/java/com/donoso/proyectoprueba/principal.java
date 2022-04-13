/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.donoso.proyectoprueba;

import static controlador.gestion.hacerConsulta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author jmcbg
 */
public class principal {

    public static void main(String[] args) throws IOException {

        List<NameValuePair> params = new ArrayList<NameValuePair>();

       // params.add(new BasicNameValuePair("nom", "John"));
        params.add(new BasicNameValuePair("dni", "123"));
        params.add(new BasicNameValuePair("email", "123"));
        params.add(new BasicNameValuePair("tlf", "123"));
        params.add(new BasicNameValuePair("rol", "Cliente"));
        params.add(new BasicNameValuePair("dir", "0"));
        //params.add(new BasicNameValuePair("pass", "123"));

        hacerConsulta("http://localhost/php/webService/api.php", params);
    }

}
