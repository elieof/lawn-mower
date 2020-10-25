package io.github.elieof.eoo.mower

import io.github.elieof.eoo.mower.Direction.EAST
import io.github.elieof.eoo.mower.Direction.NORTH
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LawnBoardTest {

    @Test
    fun blankFileName() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            LawnBoard("")
        }
        assertEquals(LawnBoard.EXCEPTION_BLANK, exception.message)
    }

    @Test
    fun invalidFile() {
        var exception = assertThrows(IllegalArgumentException::class.java) {
            LawnBoard("src/test/resources/invalid1.txt")
        }
        assertEquals(LawnBoard.EXCEPTION_INVALID_FILE, exception.message)

        exception = assertThrows(IllegalArgumentException::class.java) {
            LawnBoard("src/test/resources/invalid2.txt")
        }
        assertEquals(LawnBoard.EXCEPTION_INVALID_FILE, exception.message)
    }

    @Test
    fun run() {
        assertIterableEquals(
            listOf(LawnMower(Position(1, 3), NORTH), LawnMower(Position(5, 1), EAST)), LawnBoard().run()
        )
        LawnBoard("src/test/resources/board0.txt").run().forEach {
            assertEquals(LawnMower(Position(5, 5), NORTH), it)
        }
    }
}