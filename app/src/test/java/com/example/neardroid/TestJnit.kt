package com.example.neardroid

import com.example.myapp.Calculator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestJnit {
    lateinit var calculator: Calculator

    @BeforeEach
    fun setup() {
        calculator = Calculator()
    }

    @Test
    fun addition_isCorrect() {
        val result = calculator.add(2, 3)
        assertEquals(5, result)
    }

    @Test
    fun subtraction_isCorrect() {
        val result = calculator.subtract(5, 3)
        assertEquals(2, result)
    }
}