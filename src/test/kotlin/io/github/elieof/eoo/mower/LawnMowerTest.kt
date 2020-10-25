package io.github.elieof.eoo.mower

import io.github.elieof.eoo.mower.Direction.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll

internal class LawnMowerTest {
    companion object {
        private val TOP = Position(5, 5)
    }

    @Test
    fun toStringCorrect() {
        assertEquals("1 1 N", LawnMower(Position(1, 1), NORTH).toString())
    }

    @Test
    fun fromString() {
        val mower = LawnMower.fromString("1 2 N")
        assertEquals(LawnMower(Position(1, 2), NORTH), mower)
    }

    @Test
    fun fromStringIncorrect() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            LawnMower.fromString("35")
        }
        assertTrue { exception.message?.contains(LawnMower.PATTERN.pattern)!! }
    }

    @Test
    fun forwardNorth() {
        val mower = LawnMower.fromString("0 0 N")
        mower.forward(TOP)
        assertEquals(LawnMower(Position(0, 1), NORTH), mower)

    }

    @Test
    fun forwardNorthTop() {
        val mower = LawnMower.fromString("2 5 N")
        mower.forward(TOP)
        assertEquals(LawnMower(Position(2, 5), NORTH), mower)

    }

    @Test
    fun forwardEast() {
        val mower = LawnMower.fromString("0 0 E")
        mower.forward(TOP)
        assertEquals(LawnMower(Position(1, 0), EAST), mower)
    }

    @Test
    fun forwardEastTop() {
        val mower = LawnMower.fromString("5 2 E")
        mower.forward(TOP)
        assertEquals(LawnMower(Position(5, 2), EAST), mower)

    }

    @Test
    fun forwardWest() {
        val mower = LawnMower.fromString("1 0 W")
        mower.forward(TOP)
        assertEquals(LawnMower(Position(0, 0), WEST), mower)
    }

    @Test
    fun forwardWestTop() {
        val mower = LawnMower.fromString("0 1 W")
        mower.forward(TOP)
        assertEquals(LawnMower(Position(0, 1), WEST), mower)

    }

    @Test
    fun forwardSouth() {
        val mower = LawnMower.fromString("0 1 S")
        mower.forward(TOP)
        assertEquals(LawnMower(Position(0, 0), SOUTH), mower)
    }

    @Test
    fun forwardSouthTop() {
        val mower = LawnMower.fromString("1 0 S")
        mower.forward(TOP)
        assertEquals(LawnMower(Position(1, 0), SOUTH), mower)
    }

    @Test
    fun run(){
        val mower = LawnMower.fromString("1 2 N")
        mower.run(TOP, Instruction.fromString("GAGAGAGAA"))
        assertEquals(LawnMower(Position(1, 3), NORTH), mower)

        val mower2 = LawnMower.fromString("3 3 E")
        mower2.run(TOP, Instruction.fromString("AADAADADDA"))
        assertEquals(LawnMower(Position(5, 1), EAST), mower2)
    }
}