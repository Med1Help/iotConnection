package Iot.project.iotconnection.controllers;

import Iot.project.iotconnection.Res;
import Iot.project.iotconnection.models.Device;
import Iot.project.iotconnection.models.Links;
import Iot.project.iotconnection.models.User;
import Iot.project.iotconnection.models.UserDevice;
import Iot.project.iotconnection.repositories.DeviceRepo;
import Iot.project.iotconnection.repositories.LinksRepo;
import Iot.project.iotconnection.repositories.USerDeviceRepo;
import Iot.project.iotconnection.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private LinksRepo repo;
    @Autowired
    private UserRepo userRepo ;
    @Autowired
    private USerDeviceRepo userDeviceRepo;
    @Autowired
    private DeviceRepo deviceRepo ;
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        try{
            return ResponseEntity.ok(userRepo.save(user));
        }catch(Exception e){
            return (ResponseEntity<User>) ResponseEntity.status(HttpStatus.NO_CONTENT);
        }

    }
    @PostMapping("/login")
    public ResponseEntity<Res> login(@RequestHeader String email , @RequestHeader String password,@RequestHeader String fcmToken){
        try{
            User users = userRepo.findUserByemail(email);
            if(users == null){
                return ResponseEntity.ok(new Res("E-mail doesn't found",false));
            }else{

                if(users.getPassword().equals(password)){
                    users.setTokenFcm(fcmToken);
                    userRepo.save(users);

                    return ResponseEntity.ok(new Res("Login succesfully",true,users.getEmail(), users.getName()));
                }else{
                    return ResponseEntity.ok(new Res("Password incorrect",false));
                }
            }
        }catch(Exception e){
            return ResponseEntity.ok(new Res("there is an exception : "+e.getMessage(),false));
        }

    }
    @PostMapping("/update")
    public ResponseEntity<Res> update(@RequestBody User user){
        /*try{
            List<User> users = userRepo.findUserByemail(user.getEmail());
            if(users.isEmpty()){
                return ResponseEntity.ok(new Res("E-mail doesn't found",false));
            }else{
                User myUser = users.get(0);
                myUser.setPassword(user.getPassword());
                myUser.setName(user.getName());
                myUser.setUpdated_at(new Date());
                userRepo.save(myUser);
                return ResponseEntity.ok(new Res("User updated with new name : "+user.getName(),true));

            }
        }catch(Exception e){
            return ResponseEntity.ok(new Res("there is an exception : "+e.getMessage(),false));
        }*/
        return ResponseEntity.ok(new Res("there is an exception : not working yet",false));
    }
    @PostMapping("/delete")
    public ResponseEntity<Res> delete(@RequestBody User user){
        try{
            userRepo.deleteByNameAndEmail(user.getName(),user.getEmail());
            return ResponseEntity.ok(new Res("Delete succesfully",true));
        }catch(Exception e){
            return ResponseEntity.ok(new Res("there is an exception : "+e.getMessage(),false));
        }
    }
}
