package Iot.project.iotconnection.controllers;

import Iot.project.iotconnection.models.*;
import Iot.project.iotconnection.repositories.DeviceRepo;
import Iot.project.iotconnection.repositories.LinksRepo;
import Iot.project.iotconnection.repositories.USerDeviceRepo;
import Iot.project.iotconnection.service.FcmService;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/send-notification")
public class sendController {
    @Autowired
    FcmService fcmService;

    @Autowired
    private LinksRepo linksRepo;

    private DeviceRepo deviceRepo;
    private USerDeviceRepo userDeviceRepo;


    public sendController(FcmService fcmService , LinksRepo repo , DeviceRepo deviceRepo,USerDeviceRepo userDeviceRepo) {
        this.linksRepo = repo;
        this.fcmService = fcmService;
        this.deviceRepo = deviceRepo;
        this.userDeviceRepo = userDeviceRepo;
    }

    /*@PostMapping("/setLinks")
    public Links setLinks(@RequestBody Links setLinks ){
        System.out.println("test set links");
        Links link = new Links(setLinks.getToken(),setLinks.getTopic());
        repo.save(setLinks);
        return setLinks;
    }*/
    @PostMapping("/testToken")
    public UserDevice testToken(@RequestBody UserDevice note) throws FirebaseMessagingException {
        System.out.println("test token");
        return note;
    }

    @PostMapping("/send")
    public String sendNotification(@RequestBody HutempTopic note) throws FirebaseMessagingException {
        Device device = this.deviceRepo.findByTopic(note.getTopic());
        List<Links> links = this.linksRepo.findByDevice(device);
        User user = null;
        for(Links link : links){
            if(link.getUser().isConnected()){
                user = link.getUser();
                break;
            }
        }
        if(user == null){
            // TO-DO search the recent one that been connected
        }
        UserDevice userDevice = this.userDeviceRepo.findByDevice(device);
        System.out.println("Should send Notification");

        return fcmService.sendNoti(note,user.getTokenFcm());
    }
}
