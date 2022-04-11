/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.donoso.proyectoprueba;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author jmcbg
 */
public class ProyectoPrueba {

    public static void main(String[] args) throws IOException {
         CloseableHttpClient client = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost("http://localhost/Php/webService/nuevoUsuario.php");

    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("username", "John"));
    params.add(new BasicNameValuePair("password", "pass"));
    httpPost.setEntity(new UrlEncodedFormEntity(params));

    CloseableHttpResponse response = client.execute(httpPost);
    
    String respuesta = response.getEntity().toString();
        System.out.println(response);
    client.close();
    }
}
