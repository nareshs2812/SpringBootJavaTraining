package com.example.springbootfirst.controllers;

import com.example.springbootfirst.controllers.EmployeeController;
import com.example.springbootfirst.models.RegisterDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.springbootfirst.services.AuthService;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeControllerTest {

    @Mock
    //AuthService authService;

    @InjectMocks
    EmployeeController employeeController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testroute() {
        String result = employeeController.route();
        assertEquals("springboot ", result);
    }

    @Test
    void testgetMethod() {
        RegisterDetails emp1 = new RegisterDetails();
        RegisterDetails emp2 = new RegisterDetails();
        when(authService.getMethod()).thenReturn(Arrays.asList(emp1, emp2));

        List<RegisterDetails> result = employeeController.getMethod();

        assertEquals(2, result.size());
    }
}