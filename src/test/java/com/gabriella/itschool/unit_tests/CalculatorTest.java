package com.gabriella.itschool.unit_tests;

import com.gabriella.itschool.services.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    void testAddition_ShouldPass_WithValidInput() {
        // GIVEN
        int firstNumber = 3;
        int secondNumber = 15;
        int expectedResult = firstNumber + secondNumber;

        // WHEN
        int result = calculator.add(firstNumber, secondNumber);

        // THEN
        assertEquals(expectedResult, result, "Addition result should be equal to the expected result");
    }

    @Test
    void testSubtraction_ShouldPass_WithValidInput() {
        int firstNumber = 10;
        int secondNumber = 15;
        int expectedResult = firstNumber - secondNumber;

        int result = calculator.subtract(firstNumber, secondNumber);

        assertEquals(expectedResult, result, "Subtraction result should be equal to the expected result");
    }
}
