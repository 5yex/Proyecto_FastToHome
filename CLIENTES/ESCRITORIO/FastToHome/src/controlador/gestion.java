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
 * Clase con las distintas consultas al servidor web
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 * @since 1.0
 */
public class gestion {
    
    /**
     * Realiza una consulta de insercción, modificación o actualización y comprueba si se ha realizado la consulta
     * 
     * @param peticion objeto de tipo Peticion con el comando a realizar por el php y datos para la
     * consulta
     * @return true si se ha realizado la consulta con exito, false en caso contrario
     * @since 1.0
     */
    public static boolean hacerConsulta(Peticion peticion) {
        //System.out.println(peticion.toString());
        String json = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://localhost/Php/webService/api.php");

            List<NameValuePair> params = new ArrayList<>();

            //System.out.println("controlador.gestion.hacerConsulta() ---- PETICION ENVIADO: " + peticion.getJSON());

            //System.err.println(peticion.getJSON());
            
            params.add(new BasicNameValuePair("DATA", peticion.getJSON()));

            httpPost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));

            CloseableHttpResponse response = client.execute(httpPost);

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();

            if (entity != null) {

                String htmlTxt = EntityUtils.toString(entity);

                //System.out.println("controlador.gestion.hacerConsulta() ---- RECEPCIÓN: " + htmlTxt);

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
     * Realiza una consulta de selección que devuelve un único objeto o elemento
     * 
     * @param peticion objeto de tipo Peticion con el comando a realizar por el php y datos para la
     * consulta
     * @return JsonObject con la fila que se ha pedido en la consulta y sus
     * atributos
     */
    public static JsonObject consultaSeleccionUnico(Peticion peticion) {
        String json = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://localhost/Php/webService/api.php");

            List<NameValuePair> params = new ArrayList<>();

            //prueba
            //System.out.println("controlador.gestion.hacerConsulta() ---- PETICION ENVIADO: " + peticion.getJSON());

            params.add(new BasicNameValuePair("DATA", peticion.getJSON()));

            httpPost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));

            CloseableHttpResponse response = client.execute(httpPost);

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();

            if (entity != null) {

                String htmlTxt = EntityUtils.toString(entity);

                //System.out.println("controlador.gestion.hacerConsulta() ---- RECEPCIÓN: " + htmlTxt);

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
    
    /**
     * Realiza una consulta de selección que devuelve un varios objetos o elementos de un mismo tipo
     * 
     * @param peticion objeto de tipo Peticion con el comando a realizar por el php y datos para la
     * consulta
     * @return JsonObject con las filas que se han pedido en la consulta y sus
     * atributos
     */
    public static JsonArray consultaSeleccion(Peticion peticion) {
        String json = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://localhost/Php/webService/api.php");

            List<NameValuePair> params = new ArrayList<>();

            //System.out.println("controlador.gestion.hacerConsulta() ---- PETICION ENVIADO: " + peticion.getJSON());

            params.add(new BasicNameValuePair("DATA", peticion.getJSON()));

            httpPost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));

            CloseableHttpResponse response = client.execute(httpPost);

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();

            if (entity != null) {

                String htmlTxt = EntityUtils.toString(entity);

                //System.out.println("controlador.gestion.hacerConsulta() ---- RECEPCIÓN: " + htmlTxt);

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
    
    /**
     * Devuelve una cadena con una imagen en base 64
     *
     * @param peticion objeto de tipo Peticion con el comando a realizar por el php y datos para la
     * consulta
     * @return una cadena con una imagen en base 64
     */
    public static String consultaSeleccionImagen(Peticion peticion) {
        String json = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://localhost/Php/webService/api.php");

            List<NameValuePair> params = new ArrayList<>();

            //prueba
            //System.out.println("controlador.gestion.hacerConsulta() ---- PETICION ENVIADO: " + peticion.getJSON());

            params.add(new BasicNameValuePair("DATA", peticion.getJSON()));

            httpPost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));

            CloseableHttpResponse response = client.execute(httpPost);

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();

            if (entity != null) {

                String htmlTxt = EntityUtils.toString(entity);

                //System.out.println("controlador.gestion.hacerConsulta() ---- RECEPCIÓN: UNA IMAGEN");

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
