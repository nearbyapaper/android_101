package com.example.neardroid.unittest

import org.junit.Assert.*
import org.junit.Test

class HomeworkTest {

    @Test
    fun `test when input 0`(){
        val result = Homework.fib(0)
        assertEquals(0, result)
    }

    @Test
    fun `test when input 1`(){
        val result = Homework.fib(1)
        assertEquals(1, result)

    }

    @Test
    fun `test when input 5`(){
        val result = Homework.fib(5)
        assertEquals(5, result)
    }

    @Test
    fun `test when input 17`(){
        val result = Homework.fib(17)
        assertEquals(1597, result)
    }

    @Test
    fun `test check braces success`(){
        val result = Homework.checkBraces("f(0)")
        assertTrue(result)
    }

    @Test
    fun `test check braces failed`(){
        val result = Homework.checkBraces("f((0)")
        assertFalse(result)
    }

    @Test
    fun `test check braces failed 2`(){
        val result = Homework.checkBraces("f(0))")
        assertFalse(result)
    }
}