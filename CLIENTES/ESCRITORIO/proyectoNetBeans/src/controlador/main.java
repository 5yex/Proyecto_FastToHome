
package controlador;

import java.net.URI;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

/**
 *
 * @author jmcbg
 */
public class Main {
 
    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpUriRequest httppost = RequestBuilder.post()
                    .setUri(new URI("https://postman-echo.com/post"))
                    .addParameter("foo1", "bar1")
                    .addParameter("foo2", "bar2")
                    .build();
 
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                System.out.println(EntityUtils.toString(response.getEntity()));
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}
