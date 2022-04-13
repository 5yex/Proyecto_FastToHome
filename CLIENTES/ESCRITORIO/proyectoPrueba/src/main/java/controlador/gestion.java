/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.donoso.proyectoprueba.principal;
import com.donoso.proyectoprueba.principal;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Peticion;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author jmcbg
 */
public class gestion {

    public static boolean hacerConsulta() {
        String json = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://localhost/Php/webService/api.php");

            List<NameValuePair> params = new ArrayList<NameValuePair>();

            params.add(new BasicNameValuePair("DATA", new Peticion("prueba", null).getJSON()));

            httpPost.setEntity(new UrlEncodedFormEntity(params));

            CloseableHttpResponse response = client.execute(httpPost);

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();

            if (entity != null) {
                json = EntityUtils.toString(entity);
                System.out.println(json);

                JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
                JsonElement estado = jsonObject.get("error");
                System.out.println(estado.getAsBoolean());

            }

        } catch (UnsupportedEncodingException ex) {
            System.out.println("controlador.gestion.hacerConsulta()");
        } catch (IOException ex) {
            System.out.println("controlador.gestion.hacerConsulta()");
        } catch (ParseException ex) {
            System.out.println("controlador.gestion.hacerConsulta()");
        } catch (JsonSyntaxException ex) {
            System.out.println("Error en la consulta");
        }
        return true;
    }
}
