package org.example.controllers;

import org.example.models.Employees;
import org.example.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {
    @Autowired
    HelloWorldService hws;

    @GetMapping("/")
    public List<Employees> getMethod(){
        return hws.getMethod();
    }


    @PostMapping("/")
    public List<Employees> postMethod(@RequestBody Employees employees){
        return hws.postMethod(employees);
    }

    @PutMapping("/{id}")
    public String putMethod(@PathVariable int id, @RequestBody Employees updatedEmployee) {
        return hws.putMethod(id, updatedEmployee);
    }

    @GetMapping("/{id}")
    public Employees getEmployeeById(@PathVariable int id) {
        return hws.getEmployeeById(id);
    }


    @DeleteMapping("/{id}")
    public String deleteMethod(@PathVariable int id){
        return hws.deleteMethod(id);
    }

}
