package Iot.project.iotconnection;

import Iot.project.iotconnection.models.HutempTopic;
import Iot.project.iotconnection.service.FcmService;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/send-notification")
public class sendController {
    @Autowired
    FcmService fcmService;

    public sendController(FcmService fcmService) {
        this.fcmService = fcmService;
    }

    @GetMapping("/send")
    public String send() throws FirebaseMessagingException {
        System.out.println("Should send Notification 2 ");
        return ("eT2iJMZmQHCOadpFKD_Spx:APA91bGEH9FRtD9HT6f64rCUGXp5dX33RqKyPEZikotGuTqx1jBbpJqiMEYRexY2W-SoXLs8xH8dhbvxrEYmBrP2LHptWuXSZGu6KPmQjBByXr_gXZqMOD6xNH4ZXajHJA-0JdSzjfpL");
    }
    @PostMapping("/send")
    public String sendNotification(@RequestBody HutempTopic note) throws FirebaseMessagingException {
        System.out.println("Should send Notification");
        return fcmService.sendNoti(note, "eT2iJMZmQHCOadpFKD_Spx:APA91bGEH9FRtD9HT6f64rCUGXp5dX33RqKyPEZikotGuTqx1jBbpJqiMEYRexY2W-SoXLs8xH8dhbvxrEYmBrP2LHptWuXSZGu6KPmQjBByXr_gXZqMOD6xNH4ZXajHJA-0JdSzjfpL");
    }
}
