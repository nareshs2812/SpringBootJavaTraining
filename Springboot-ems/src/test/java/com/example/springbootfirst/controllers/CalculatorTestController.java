package com.example.springbootfirst.controllers;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTestController {

    Calculator calculator = new Calculator();

    @Test
    public void testAddNumbers() {
        int result = calculator.addNumbers(10, 7);
        assertEquals(17, result);
    }

    @Test
    public void testSubtractNumbers() {
        int result = calculator.subtractNumbers(100, 45);
        assertEquals(55, result);
    }

    @Test
    public void testMultiplyNumbers() {
        int result = calculator.multiplyNumbers(6, 9);
        assertEquals(54, result);
    }

    @Test
    public void testDivideNumbers() {
        int result = calculator.divideNumbers(81, 9);
        assertEquals(9, result);
    }

    @Test
    public void testModuloNumbers() {
        int result = calculator.moduloNumbers(22, 5);
        assertEquals(2, result);
    }
}
