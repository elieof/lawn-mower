package io.github.elieof.eoo.mower

import io.github.elieof.eoo.mower.Instruction.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class InstructionTest {

    @Test
    fun toStringCorrect() {
        assertEquals("A", FORWARD.toString())
        assertEquals("G", LEFT.toString())
        assertEquals("D", RIGHT.toString())
    }

    @Test
    fun from() {
        assertEquals(FORWARD, Instruction.from('A'))
        assertEquals(LEFT, Instruction.from('G'))
        assertEquals(RIGHT, Instruction.from('D'))
    }

    @Test
    fun fromIncorrect() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Instruction.from('L')
        }
        assertEquals(Instruction.EXCEPTION_NOT_FOUND, exception.message)
    }

    @Test
    fun fromString() {
        val instructions = Instruction.fromString("GDA")
        assertEquals(LEFT, instructions[0])
        assertEquals(RIGHT, instructions[1])
        assertEquals(FORWARD, instructions[2])
    }

    @Test
    fun fromStringIncorrect() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Instruction.fromString("35")
        }
        assertTrue { exception.message?.contains(Instruction.PATTERN.pattern)!! }
    }
}