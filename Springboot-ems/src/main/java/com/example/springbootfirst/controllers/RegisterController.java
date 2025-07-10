package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.models.LoginDetails;
import com.example.springbootfirst.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    public String register(@RequestBody UserDetailsDto request){
        return registerService.registerNewUser(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDetails request) {
        boolean isValid = registerService.authenticate(request.getUserName(), request.getPassword());
        if (isValid) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody UserDetailsDto request) {
        return registerService.updateUser(id, request);
    }
}
