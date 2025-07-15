package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee updateEmployee(Long id, Employee newData) {
        Optional<Employee> empOpt = repository.findById(id);
        if (empOpt.isPresent()) {
            Employee emp = empOpt.get();
            emp.setName(newData.getName());
            emp.setRole(newData.getRole());
            emp.setTodo(newData.getTodo());
            return repository.save(emp);
        }
        return new Employee();
    }

    public List<Employee> getByRole(String role) {
        return repository.findByRole(role);
    }

    public String getTodo(Long id) {
        Optional<Employee> emp = repository.findById(id);
        if (emp.isPresent()) {
            return "TODO for " + emp.get().getName() + ": " + emp.get().getTodo();
        }
        return "Employee not found";
    }
}
