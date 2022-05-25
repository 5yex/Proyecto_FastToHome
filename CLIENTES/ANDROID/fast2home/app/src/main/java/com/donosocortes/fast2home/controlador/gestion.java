package com.donosocortes.fast2home.controlador;

import com.donosocortes.fast2home.modelo.Peticion;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class gestion {
    public static boolean hacerConsulta(Peticion peticion) {
        String json = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://10.0.2.2/Php/webService/api.php");

            List<NameValuePair> params = new ArrayList<>();

            System.out.println("controlador.gestion.hacerConsulta() ---- PETICION ENVIADO: " + peticion.getJSON());

            params.add(new BasicNameValuePair("DATA", peticion.getJSON()));

            httpPost.setEntity(new UrlEncodedFormEntity(params));

            CloseableHttpResponse response = client.execute(httpPost);

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();

            if (entity != null) {

                String htmlTxt = EntityUtils.toString(entity);

                System.out.println("controlador.gestion.hacerConsulta() ---- RECEPCIÓN: " + htmlTxt);

                JsonObject jsonObject = new JsonParser().parse(htmlTxt).getAsJsonObject();
                return !jsonObject.get("error").getAsBoolean();
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }
}
