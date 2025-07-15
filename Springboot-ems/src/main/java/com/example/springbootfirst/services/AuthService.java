package com.example.springbootfirst.services;


import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.Roles;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import com.example.springbootfirst.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public String updateEmployee(int id , RegisterDetails registerDetails){
    registerDetailsRepository.save(registerDetails);
    return "Employee updated successfully";
}
public List<RegisterDetails> getAllEmployeesByRoleSer(String role) {
    return registerDetailsRepository.findByRolesRoleName(role);
}



public String authenticate(RegisterDetails login) {
    RegisterDetails user = registerDetailsRepository.findByEmail(login.getEmail());
    if(user != null){
        if (passwordEncoder.matches(login.getPassword(),user.getPassword())){
            return "Login Successful";
        }
    }
    return "Login Not Successful";
}
}