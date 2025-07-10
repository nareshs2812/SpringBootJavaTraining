package com.example.springbootfirst.services;

import com.example.springbootfirst.config.SpringConfiguration;
import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.RegisterDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RegisterDetailsRepo registerDetailsRepo;

    public String addNewEmployee(RegisterDetails registerDetails){
        RegisterDetails registerDetails1 = new RegisterDetails();

        registerDetails1.setEmpId(registerDetails.getEmpId());
        registerDetails1.setName(registerDetails.getName());
        registerDetails1.setEmail(registerDetails.getEmail());
        registerDetails1.setGender(registerDetails.getGender());
        registerDetails1.setPassword(passwordEncoder.encode(registerDetails.getPassword()));
        registerDetails1.setDateOfBirth(registerDetails.getDateOfBirth());
        registerDetails1.setRole(registerDetails.getRole());


        registerDetailsRepo.save(registerDetails1);

        return "Employee is added sucessfully";
    }

    public String authenticate(RegisterDetails login) {
        RegisterDetails user = registerDetailsRepo.findByEmail(login.getEmail());
        if(user.getEmail() != null){
            if(passwordEncoder.matches(login.getPassword(), user.getPassword())){
                return "user login sucessfull";
            }
            else{
                return "Enter the correct password";
            }
        }
        else{
            return "Enter the correct email";
        }
    }
}