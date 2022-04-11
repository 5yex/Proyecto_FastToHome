/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.donoso.proyectoprueba;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author jmcbg
 */
public class ProyectoPrueba {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost/Php/webService/nuevoUsuario.php");

        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("nom", "John"));
        params.add(new BasicNameValuePair("dni", "123"));
        params.add(new BasicNameValuePair("email", "123"));
        params.add(new BasicNameValuePair("tlf", "123"));
        params.add(new BasicNameValuePair("rol", "Cliente"));
        params.add(new BasicNameValuePair("dir", "0"));
        params.add(new BasicNameValuePair("pass", "123"));
        httpPost.setEntity(new UrlEncodedFormEntity(params));

        HttpResponse response = client.execute(httpPost);

        HttpEntity entity = response.getEntity();
        Header headers = entity.getContentType();

        if (entity != null) {
            String result = EntityUtils.toString(entity);
            System.out.println(result);
        }

        client.close();
    }
}
