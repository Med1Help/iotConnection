package Iot.project.iotconnection.configuration;

import com.google.api.client.util.Value;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Configuration
public class FcmConf {
    @Value("${app.firebase-configuration-file}")
    private String path = "fcm/e-senhealt-firebase-adminsdk-a42oy-a9ca0d2c0c.json";
    @Bean
    public FirebaseMessaging firebaseMessaging() throws IOException {
          GoogleCredentials credentials = GoogleCredentials.fromStream(
                  new ClassPathResource(path).getInputStream()
          );
          FirebaseOptions options = FirebaseOptions.builder().setCredentials(credentials).build();
          FirebaseApp firebaseApp = FirebaseApp.initializeApp(options,"my_app");
          return FirebaseMessaging.getInstance(firebaseApp);
    }

}
