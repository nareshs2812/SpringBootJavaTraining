package com.example.springbootfirst.controllers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTestController {

    CalculatorController calculator = new CalculatorController();

    @Test
    public void testAddNumbers() {
        int result = calculator.addNumbers(10, 7);
        System.out.println("Addition : " + result);
        assertEquals(17, result);
    }

    @Test
    public void testSubtractNumbers() {
        int result = calculator.subtractNumbers(100, 45);
        System.out.println("Subtraction : " + result);
        assertEquals(55, result);
    }

    @Test
    public void testMultiplyNumbers() {
        int result = calculator.multiplyNumbers(6, 9);
        System.out.println("Multiplication : " + result);
        assertEquals(54, result);
    }

    @Test
    public void testDivideNumbers() {
        int result = calculator.divideNumbers(81, 9);
        System.out.println("Division : " + result);
        assertEquals(9, result);
    }

    @Test
    public void testModuloNumbers() {
        int result = calculator.moduloNumbers(22, 5);
        System.out.println("Modulo : " + result);
        assertEquals(2, result);
    }
}