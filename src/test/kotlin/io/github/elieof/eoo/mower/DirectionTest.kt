package io.github.elieof.eoo.mower

import io.github.elieof.eoo.mower.Direction.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DirectionTest {

    @Test
    fun toStringCorrect() {
        assertEquals("N", NORTH.toString())
        assertEquals("E", EAST.toString())
        assertEquals("W", WEST.toString())
        assertEquals("S", SOUTH.toString())
    }

    @Test
    fun right() {
        assertEquals(EAST, NORTH.right())
        assertEquals(SOUTH, EAST.right())
        assertEquals(NORTH, WEST.right())
        assertEquals(WEST, SOUTH.right())
    }

    @Test
    fun left() {
        assertEquals(WEST, NORTH.left())
        assertEquals(NORTH, EAST.left())
        assertEquals(SOUTH, WEST.left())
        assertEquals(EAST, SOUTH.left())
    }

    @Test
    fun from() {
        assertEquals(NORTH, Direction.from('N'))
        assertEquals(EAST, Direction.from('E'))
        assertEquals(WEST, Direction.from('W'))
        assertEquals(SOUTH, Direction.from('S'))
    }

    @Test
    fun fromIncorrect() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Direction.from('L')
        }
        assertEquals(Direction.EXCEPTION_NOT_FOUND, exception.message)

    }
}