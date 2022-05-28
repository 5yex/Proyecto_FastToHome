/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.util.ArrayList;
import java.util.List;
import modelo.Peticion;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

/**
 *
 * @author jmcbg
 */
public class gestion {

    public static boolean hacerConsulta(Peticion peticion) {
        //System.out.println(peticion.toString());
        String json = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://localhost/Php/webService/api.php");

            List<NameValuePair> params = new ArrayList<>();

            System.out.println("controlador.gestion.hacerConsulta() ---- PETICION ENVIADO: " + peticion.getJSON());

            params.add(new BasicNameValuePair("DATA", peticion.getJSON()));

            httpPost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));

            CloseableHttpResponse response = client.execute(httpPost);

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();

            if (entity != null) {

                String htmlTxt = EntityUtils.toString(entity);

                System.out.println("controlador.gestion.hacerConsulta() ---- RECEPCIÓN: " + htmlTxt);

                JsonObject jsonObject = new JsonParser().parse(htmlTxt).getAsJsonObject();
                if(jsonObject.get("error").getAsBoolean()){
                    return true;
                }else{
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
            HttpPost httpPost = new HttpPost("http://localhost/Php/webService/api.php");

            List<NameValuePair> params = new ArrayList<>();

            //prueba
            System.out.println("controlador.gestion.hacerConsulta() ---- PETICION ENVIADO: " + peticion.getJSON());

            params.add(new BasicNameValuePair("DATA", peticion.getJSON()));

            httpPost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));

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
            HttpPost httpPost = new HttpPost("http://localhost/Php/webService/api.php");

            List<NameValuePair> params = new ArrayList<>();

            //prueba
            System.out.println("controlador.gestion.hacerConsulta() ---- PETICION ENVIADO: " + peticion.getJSON());

            params.add(new BasicNameValuePair("DATA", peticion.getJSON()));

            httpPost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));

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
            return null;
        }
    }
    
    public static String consultaSeleccionImagen(Peticion peticion) {
        String json = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://localhost/Php/webService/api.php");

            List<NameValuePair> params = new ArrayList<>();

            //prueba
            System.out.println("controlador.gestion.hacerConsulta() ---- PETICION ENVIADO: " + peticion.getJSON());

            params.add(new BasicNameValuePair("DATA", peticion.getJSON()));

            httpPost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));

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
