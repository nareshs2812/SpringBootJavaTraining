package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.Employee;
import com.example.springbootfirst.repository.EmployeeRepository;
import com.example.springbootfirst.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {
        Employee emp1 = new Employee(1, "John", "Developer");
        Employee emp2 = new Employee(2, "Jane", "Tester");

        when(employeeRepository.findAll()).thenReturn(Arrays.asList(emp1, emp2));

        List<Employee> result = employeeService.getMethod();

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getName());
        assertEquals("Jane", result.get(1).getName());
    }

    @Test
    void testGetEmployeeById() {
        Employee emp = new Employee(1, "Naresh", "Manager");

        when(employeeRepository.findById(1)).thenReturn(java.util.Optional.of(emp));

        Employee result = employeeService.getEmployeeById(1);
        assertEquals("Alice", result.getName());
        assertEquals("Manager", result.getJob());
    }

    @Test
    void testGetEmployeeByJob() {
        Employee emp = new Employee(3, "Muthu", "Analyst");

        when(employeeRepository.findByJob("Analyst")).thenReturn(List.of(emp));

        List<Employee> result = employeeService.getEmployeeByJob("Analyst");
        assertEquals(1, result.size());
        assertEquals("Raj", result.get(0).getName());
    }

    @Test
    void testAddEmployee() {
        Employee emp = new Employee(4, "Bob", "Engineer");

        when(employeeRepository.save(emp)).thenReturn(emp);

        String result = employeeService.addEmployee(emp);
        assertEquals("Employee Added Successfully!!!", result);
    }

    @Test
    void testUpdateEmployee() {
        Employee emp = new Employee(4, "Bob", "Engineer");

        when(employeeRepository.save(emp)).thenReturn(emp);

        String result = employeeService.updateEmployee(emp);
        assertEquals("Employee Updated Successfully!!!", result);
    }

    @Test
    void testDeleteEmployeeById() {
        String result = employeeService.deleteEmployeeById(5);
        assertEquals("Employee Deleted Successfully!!!", result);
    }
}