package com.example.SpringSecurity.Controller;

import com.example.SpringSecurity.Model.Users;
import com.example.SpringSecurity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
           return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){

        return service.verify(user);
    }

}
