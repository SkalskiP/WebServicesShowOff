package util;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class UserValidator {
    public static Identity validateIdToken(String idToken) {
        return UserValidator.sendToken(idToken);
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
            HttpResponse response = httpClient.execute(post);
            String json = IOUtils.toString(response.getEntity().getContent());
            return gson.fromJson(json, Identity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
