package Iot.project.iotconnection.controllers;

import Iot.project.iotconnection.Res;
import Iot.project.iotconnection.models.*;
import Iot.project.iotconnection.repositories.DeviceRepo;
import Iot.project.iotconnection.repositories.LinksRepo;
import Iot.project.iotconnection.repositories.USerDeviceRepo;
import Iot.project.iotconnection.repositories.UserRepo;
import com.google.api.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user_device")
public class UserDeviceController {
    @Autowired
    private USerDeviceRepo userDeviceRepo ;
    @Autowired
    private LinksRepo linksRepo;
    @Autowired
    private UserRepo userRepo ;
    @Autowired
    private DeviceRepo deviceRepo ;
    @PostMapping("/register")
    public ResponseEntity<Res> register(@RequestBody FullRegistration registration){
        try{
        System.out.println(registration.toString());
        User myUser = userRepo.findUserByemail(registration.getUserEmail());
        Device device = new Device(registration.getTopic(), "not connected yet");
        UserDevice userDevice = new UserDevice(myUser,registration.getName(), registration.getInfo(), registration.getAge(), new Date(), new Date(),device,registration.getService(), registration.getLit(), registration.getNum_patient());
        userDeviceRepo.save(userDevice);
        deviceRepo.save(device);
        Links link = new Links(myUser,device);
        linksRepo.save(link);
        return ResponseEntity.ok(new Res("registration succesfully",true));
        }catch(Exception e){
            return ResponseEntity.ok(new Res("registration : "+e.getMessage(),true));

        }

    }
   @GetMapping("/user_devices")
   public ResponseEntity<Optional<List<UserDevice>>> getUserDevices(@RequestHeader("email") String email){
       List<UserDevice> userDevices = null;
        try{
           User myUser = userRepo.findUserByemail(email);
           userDevices = userDeviceRepo.findByUser(myUser);
           return ResponseEntity.ok(Optional.ofNullable(userDevices));
       }catch(Exception e){
           return ResponseEntity.ok(Optional.ofNullable(userDevices));
       }
   }
   @GetMapping("/delete/{id}")
    public Res delete(@PathVariable int id ){
       try {
           userDeviceRepo.deleteById(id);
           return new Res("delete succesfully !!! ",true,"","");
       }catch(Exception e){
           return new Res("delete failed !!! "+e.getMessage(),true,"","");
       }
   }
}
