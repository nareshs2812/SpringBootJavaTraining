package com.example.springbootfirst.controllers;

public class CalculatorController {

    public int addNumbers(int a, int b) {
        return a + b;
    }

    public int subtractNumbers(int a, int b) {
        return a - b;
    }

    public int multiplyNumbers(int a, int b) {
        return a * b;
    }

    public int divideNumbers(int a, int b) {
        return a / b;
    }

    public int moduloNumbers(int a, int b) {
        return a % b;
    }
}