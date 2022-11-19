package com.example.controller;

import com.example.model.User;
import com.example.service.JWTSecurityToken;
import com.example.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class Home {

    @Autowired
    UserService userService;

    @Autowired
    JWTSecurityToken jwtSecurityToken;

    @RequestMapping("/welcome")
    public String welcome(){
        String text="This is a private page";
        return text;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        List<User> users=userService.getAllUser();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PostMapping("/login")
    @HystrixCommand(fallbackMethod="fallbackLogin")
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    public ResponseEntity<?> credentialCheck(@RequestBody User user){
        ResponseEntity responseEntity;
        try{
            Thread.sleep(100);
            User userObj=userService.findByUsernameAndPasswordCheck(user.getUsername(),user.getPassword());
            if(userObj.getUsername().equals(user.getUsername())){
                //Creating a Token
                Map<String,String> tokenMap=jwtSecurityToken.generateToen(userObj);
                responseEntity=new ResponseEntity<>(tokenMap,HttpStatus.OK);
            }else{
                responseEntity=new ResponseEntity<>("Invalid USer",HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            responseEntity=new ResponseEntity<>("Some Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    public ResponseEntity<?> fallbackLogin(@RequestBody User user){
        String msg = "Service Under Maintenance";
        return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
    }
}
