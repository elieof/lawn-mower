package io.github.elieof.eoo.mower

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

internal class PositionTest {

    @Test
    fun `Position x should be positive`(){
        val exception = assertThrows(IllegalArgumentException::class.java){
            Position(-1, 6)
        }
        assertEquals(Position.EXCEPTION_X_NEGATIVE_VALUE, exception.message)
    }

    @Test
    fun `Position y should be positive`(){
        val exception = assertThrows(IllegalArgumentException::class.java){
            Position(5, -6)
        }
        assertEquals(Position.EXCEPTION_Y_NEGATIVE_VALUE, exception.message)
    }

    @Test
    fun `Position toString is correctly formatted`() {
        assertEquals("1 1", Position(1, 1).toString())
    }

    @Test
    fun `Position can be created from correctly formatted string`() {
        val position = Position.fromString("35 6")
        assertEquals(35, position.x)
        assertEquals(6, position.y)
    }

    @Test
    fun `Position created from incorrectly formatted string throw IllegalArgumentException`() {
        val exception1 = assertThrows(IllegalArgumentException::class.java){
            Position.fromString("35 khgdfu")
        }
        assertTrue { exception1.message?.contains(Position.PATTERN.pattern)!! }

        val exception2 = assertThrows(IllegalArgumentException::class.java){
            Position.fromString("-35 28")
        }
        assertTrue { exception2.message?.contains(Position.PATTERN.pattern)!! }
    }

}