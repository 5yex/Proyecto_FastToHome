/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.donoso.proyectoprueba;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author jmcbg
 */
public class ProyectoPrueba {

    public static void main(String[] args) {
         CloseableHttpClient client = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost("http://www.example.com");

    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("username", "John"));
    params.add(new BasicNameValuePair("password", "pass"));
    httpPost.setEntity(new UrlEncodedFormEntity(params));

    CloseableHttpResponse response = client.execute(httpPost);
    assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
    client.close();
    }
}
