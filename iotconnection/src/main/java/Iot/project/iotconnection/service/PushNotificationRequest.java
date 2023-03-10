package Iot.project.iotconnection.service;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class PushNotificationRequest {
    private String title;
    private String message;
    private String topic;
    private String token;
}
