package com.example.springbootfirst.controllers;



import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.services.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PutMapping("/{id}")
public String updateEmployee(@PathVariable int id, @RequestBody RegisterDetails emp){
    return authService.updateEmployee(id,emp);
}

@GetMapping("/roles/{roles}")
public List<RegisterDetails> getEmployeeByRole(@PathVariable String roles){
    return authService.getAllEmployeesByRoleSer(roles);
}
}