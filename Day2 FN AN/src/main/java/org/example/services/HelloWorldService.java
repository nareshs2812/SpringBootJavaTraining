package org.example.services;

import org.example.models.Employees;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {

    List<Employees> emp = new ArrayList<>(
            Arrays.asList(
                    new Employees(1,"prasanth","Trainner"),
                    new Employees(2,"Yuvaraj","Faculty"))
    );

    public List<Employees> getMethod(){
        return emp;
    }

    public List<Employees> postMethod(Employees newEmployees){
        emp.add(newEmployees);
        return emp;
    }

    public String putMethod(int id, Employees updatedEmployee) {
        for (Employees e : emp) {
            if (e.getEmpid() == id) {
                e.setName(updatedEmployee.getName());
                e.setJob(updatedEmployee.getJob());
                return "Employee with ID " + id + " was updated.";
            }
        }
        return "Employee with ID " + id + " not found.";
    }

    public Employees getEmployeeById(int id) {
        for (Employees e : emp) {
            if (e.getEmpid() == id) {
                return e;
            }
        }
        return null;
    }

    public String deleteMethod(int id) {
        boolean removed = emp.removeIf(e -> e.getEmpid() == id);
        if (removed) {
            return "Employee with ID " + id + " was removed.";
        } else {
            return "Employee with ID " + id + " not found.";
        }
    }
}
