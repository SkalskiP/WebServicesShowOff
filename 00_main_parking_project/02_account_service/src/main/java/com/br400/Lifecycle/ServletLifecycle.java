package com.br400.Lifecycle;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.io.Resources;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ServletLifecycle implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        this.setupFirebase();
    }

    @Override
    public void contextDestroyed(ServletContextEvent contextEvent) {
        /* Do Shutdown stuff. */
    }

    private void setupFirebase() {
        URL url = Resources.getResource("firebase-admin.json");
        InputStream serviceAccount = null;
        try {
            serviceAccount = url.openStream();
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://webservicesshowoff.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}