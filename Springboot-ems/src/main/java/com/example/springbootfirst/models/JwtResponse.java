package com.example.springbootfirst.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor


public class JwtResponse{
    private String token;
    private String username;
    private String roles;
}