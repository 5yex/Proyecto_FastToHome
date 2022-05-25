package com.donosocortes.fast2home.controlador;

public class gestion {
    public static boolean hacerConsulta(Peticion peticion) {
        String json = null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://localhost/Php/webService/api.php");

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
