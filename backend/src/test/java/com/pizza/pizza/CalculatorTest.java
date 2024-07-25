package com.pizza.pizza;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void sun() {
//        Calculator calculator = new Calculator(); esli bi ne bilo beforeeach void setUp function to nujno biilo komentarii udalit
        int sum = calculator.sum(10, 15);

        Assertions.assertEquals(25, sum);
    }

    @Test
    void evenOrOdd_evenNumber() {
//        Calculator calculator = new Calculator();
        boolean even = calculator.evenOrOdd(10);
        Assertions.assertTrue(even);
    }

    @Test
    void evenOrOdd_oddNumber() {
//        Calculator calculator = new Calculator();
        boolean even = calculator.evenOrOdd(15);
        Assertions.assertFalse(even);
    }

    @Test
    void divide_byZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}
