package com.example.calculatorService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTests {

    Calculator calculator=new Calculator();



    @Test
    void whenInputArePositive_thenReturnPositive(){
        int a=10;
        int b=5;
        int expected=5;

        int actual=calculator.subtract(a,b);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void whenBIsGreaterA_thenReturnPositiveReminder(){
        int a=10;
        int b=5;
        int expected=2;
        int actual=calculator.div(a,b);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void whenBIsZero_thenReturnExceptions(){
        int a=10;
        int b=0;
        Assertions.assertThrows(ArithmeticException.class,()->{
            calculator.div(a,b);
        });
    }
}
