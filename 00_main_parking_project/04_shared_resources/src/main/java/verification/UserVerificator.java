package verification;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class UserVerificator {
    public static Identity validateIdToken(String idToken) {
        return UserVerificator.sendToken(idToken);
    }

    private static Identity sendToken(String token) {
        try {
            String postUrl = "http://localhost:8080/auth/rest/verification";
            Gson gson = new Gson();
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(postUrl);
            StringEntity postingString = new StringEntity(gson.toJson(new TokenPayload(token)));
            post.setEntity(postingString);
            post.setHeader("Content-type", "application/json");
            post.setHeader("accept", "application/json");
            HttpResponse response = httpClient.execute(post);
            System.out.println("TEST");
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
            return gson.fromJson(result, Identity.class);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Identity(false, false, null);
    }
}
