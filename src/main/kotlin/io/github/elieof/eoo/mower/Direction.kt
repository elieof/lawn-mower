package io.github.elieof.eoo.mower

import java.lang.IllegalArgumentException

enum class Direction(private val value: Char) {
    NORTH('N'),
    EAST('E'),
    WEST('W'),
    SOUTH('S');

    companion object {
        internal val EXCEPTION_NOT_FOUND = "Direction not found"
        private val VALUES: Map<Char, Direction> = values().associateBy { it.value }

        @JvmStatic
        fun from(value: Char): Direction = VALUES[value] ?: throw IllegalArgumentException(EXCEPTION_NOT_FOUND)

    }

    override fun toString(): String = value.toString()

    fun right(): Direction = when (this) {
        NORTH -> EAST
        EAST -> SOUTH
        WEST -> NORTH
        SOUTH -> WEST
    }

    fun left(): Direction = when (this) {
        NORTH -> WEST
        EAST -> NORTH
        WEST -> SOUTH
        SOUTH -> EAST
    }
}