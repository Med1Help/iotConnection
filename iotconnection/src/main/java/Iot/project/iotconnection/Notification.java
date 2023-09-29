package Iot.project.iotconnection;

import Iot.project.iotconnection.models.HutempTopic;
import Iot.project.iotconnection.models.Links;
import Iot.project.iotconnection.models.UserDevice;
import Iot.project.iotconnection.repositories.DeviceRepo;
import Iot.project.iotconnection.repositories.LinksRepo;
import Iot.project.iotconnection.repositories.USerDeviceRepo;
import Iot.project.iotconnection.service.FcmService;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class Notification {
    private LinksRepo repo;
    @Autowired
    FcmService fcmService;

    @Autowired
    private DeviceRepo deviceRepo;

    @Autowired
    private USerDeviceRepo userDeviceRepo;

    public Notification(LinksRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/send")
    public void handleMessage(@RequestHeader("topic") String top , @RequestHeader("percentage") String waterPercentage) throws MessagingException, FirebaseMessagingException {
        String topic = top;
        System.out.println("that is your topic : "+top+" waterPercentage : "+waterPercentage);
        Links link = null;
        /*try {
            link = (Links) repo.findLinksBytopic(top).get(0);
            System.out.println(" from topic : "+topic+" token :  "+link.getToken());
            if(link == null){
                System.out.println(" from topic : "+topic);
            }
        }catch(Exception e){
            System.out.println("error BD");
        }
        String humidity="8",temperature="8",water = "8";
        try{

        }catch(Exception e){
            System.out.println(e);
        }
        long id_device = deviceRepo.findBytoken(link.getTopic()).getId();
        UserDevice userDevice  = userDeviceRepo.findByIdDevice(id_device);
        HutempTopic note = new HutempTopic(humidity,temperature,userDevice.getName(),""+waterPercentage,userDevice.getId());
        fcmService.sendNoti(note, link.getToken());

        //setup firebase server to send notification to user's token
        System.out.println(" waterPercentage  : "+" from topic : "+topic+" after that test we will send it to "+link.getTopic());*/
        System.out.println(" waterPercentage  : "+" from topic : "+topic+" "+waterPercentage+"%");

    }
    @GetMapping("/test")
    public String test(){
        System.out.println("test");
        return "test";
    }

}
