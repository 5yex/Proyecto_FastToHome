/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.donosocortes.fast2home.controlador;

import android.os.AsyncTask;

import com.donosocortes.fast2home.modelo.Peticion;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;


import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.CloseableHttpClient;
import cz.msebera.android.httpclient.impl.client.HttpClients;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.util.EntityUtils;

/**
 *
 * @author jmcbg
 */
public class gestion {

    public static boolean hacerConsulta(Peticion peticion) {
        String json = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://10.0.2.2/Php/webService/api.php");
            //HttpPost httpPost = new HttpPost("http://localhost/Php/webService/api.php");

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

    /**
     *
     * @param peticion Objeto con comando a realizar por el php y datos para la
     * consulta
     * @return json object con las filas que se han pedido en la consulta y sus
     * atributos
     */
    public static JsonObject consultaSeleccionUnico(Peticion peticion) {
        String json = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            //HttpPost httpPost = new HttpPost("http://localhost/Php/webService/api.php");
            HttpPost httpPost = new HttpPost("http://10.0.2.2/Php/webService/api.php");

            List<NameValuePair> params = new ArrayList<>();

            //prueba
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

                boolean hayError = jsonObject.get("error").getAsBoolean();

                if (hayError) {
                    String errorMsg = jsonObject.get("datos").getAsString();
                    throw new Exception(errorMsg);
                } else {
                    return jsonObject.get("datos").getAsJsonArray().get(0).getAsJsonObject();
                }
            }
            return null;

        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }



    public static JsonArray consultaSeleccion(Peticion peticion) {
        String json = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
           // HttpPost httpPost = new HttpPost("http://localhost/Php/webService/api.php");
            HttpPost httpPost = new HttpPost("http://10.0.2.2/Php/webService/api.php");

            List<NameValuePair> params = new ArrayList<>();

            //prueba
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

                boolean hayError = jsonObject.get("error").getAsBoolean();

                if (hayError) {
                    String errorMsg = jsonObject.get("datos").getAsString();
                    throw new Exception(errorMsg);
                } else {
                    return jsonObject.get("datos").getAsJsonArray();
                }
            }
            return null;

        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    
    public static String consultaSeleccionImagen(Peticion peticion) {
        String json = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            //HttpPost httpPost = new HttpPost("http://localhost/Php/webService/api.php");
            HttpPost httpPost = new HttpPost("http://10.0.2.2/Php/webService/api.php");

            List<NameValuePair> params = new ArrayList<>();

            //prueba
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

                boolean hayError = jsonObject.get("error").getAsBoolean();

                if (hayError) {
                    String errorMsg = jsonObject.get("datos").getAsString();
                    throw new Exception(errorMsg);
                } else {
                    return jsonObject.get("datos").getAsString();
                }
            }
            return null;

        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }
}
