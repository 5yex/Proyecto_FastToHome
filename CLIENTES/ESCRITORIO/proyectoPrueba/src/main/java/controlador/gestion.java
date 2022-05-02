/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
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

/**
 *
 * @author jmcbg
 */
public class gestion {

    public static boolean hacerConsulta(Peticion peticion) {
        String json = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://localhost/Php/webService/api.php");

            List<NameValuePair> params = new ArrayList<>();
            
            //prueba
            System.out.println(peticion.getJSON());
            
            params.add(new BasicNameValuePair("DATA", peticion.getJSON()));

            httpPost.setEntity(new UrlEncodedFormEntity(params));

            CloseableHttpResponse response = client.execute(httpPost);

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            
            if (entity != null) {
                
                String htmlTxt = EntityUtils.toString(entity);
                
                System.err.println(htmlTxt);
                
                JsonObject jsonObject = new JsonParser().parse(htmlTxt).getAsJsonObject();
                return !jsonObject.get("error").getAsBoolean();
            }else{
            return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }
    
    public static String consultaSeleccion(Peticion peticion) {
        String json = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://localhost/Php/webService/api.php");

            List<NameValuePair> params = new ArrayList<>();
            
            //prueba
            System.out.println(peticion.getJSON());
            
            params.add(new BasicNameValuePair("DATA", peticion.getJSON()));

            httpPost.setEntity(new UrlEncodedFormEntity(params));

            CloseableHttpResponse response = client.execute(httpPost);

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            
            if (entity != null) {
                
                String htmlTxt = EntityUtils.toString(entity);
                
                System.err.println(htmlTxt);
                
                JsonObject jsonObject = new JsonParser().parse(htmlTxt).getAsJsonObject();
                return jsonObject.get("error").getAsString();
            }else{
                return "error entity es null";
            }
        } catch (Exception ex) {
            return "excepcion";
        }
    }
}
