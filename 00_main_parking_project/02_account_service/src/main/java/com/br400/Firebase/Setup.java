package com.br400.Firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.IOException;

public class Setup implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        this.setup();
    }

    @Override
    public void contextDestroyed(ServletContextEvent contextEvent) {
        /* Do Shutdown stuff. */
    }

    private void setup() {
        try {
            FileInputStream serviceAccount = new FileInputStream(Setup.class.getClassLoader().getResource("WEB-INF/classes/firebase-admin.json").getFile());

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