package Iot.project.iotconnection.service;

import Iot.project.iotconnection.models.HutempTopic;
import Iot.project.iotconnection.models.Links;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FcmService {
    private FirebaseMessaging firebaseMessaging;

    public FcmService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }
    public String sendNoti(HutempTopic msg,String token)throws FirebaseMessagingException {
        Notification notification = Notification
                .builder()
                .setTitle(msg.getName()+" est humide ")
                .setBody("Humidité : "+msg.getWater()+"%")
                .build();
        Map myData = new HashMap<>();
        myData.put("water",msg.getWater());
        myData.put("Name",msg.getName());
        Message message = Message
                .builder()
                .setToken(token)
                .setNotification(notification)
                .putAllData(myData)
                .build();

        return firebaseMessaging.send(message);
    }
}
