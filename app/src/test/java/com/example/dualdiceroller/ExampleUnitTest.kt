package com.example.dualdiceroller

import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun generates_number(){
        val dice = Dice(4)
        val rollResult = dice.roll()
        assertTrue("The value of dice roll was not in between 1 to 6!", rollResult in 1..6)

    }
}