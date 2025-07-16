package com.example.springbootfirst.controllers;

import com.example.springbootfirst.jwt.JwtTokenProvider;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.models.LoginDetails;
import com.example.springbootfirst.services.RegisterService;
import com.example.springbootfirst.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import com.example.springbootfirst.models.RegisterDetails;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/register")
    public String register(@RequestBody UserDetailsDto request){
        return registerService.registerNewUser(request);
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginDetails request) {
        boolean isValid = registerService.authenticate(request.getUserName(), request.getPassword());
        Map<String, Object> response = new LinkedHashMap<>();
        if (isValid) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword())
            );
            String token = jwtTokenProvider.generateToken(authentication);
            String username = jwtTokenProvider.getUsernameFromToken(token);
            String role = jwtTokenProvider.getRoleFromToken(token);
            response.put("username", username);
            response.put("message", "Login successful");
            response.put("role", role);
            response.put("token", token);
        } else {
            response.put("message", "Invalid Details");
        }
        return response;
    }



    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody UserDetailsDto request) {
        return registerService.updateUser(id, request);
    }

    @GetMapping("/role/{roleName}")
    public List<RegisterDetails> getUsersByRole(@PathVariable String roleName) {
        return registerService.getUsersByRole(roleName);
    }

    @GetMapping("/protected")
    public String protectedEndpoint() {
        return "Token is valid. Access granted!";
    }

}