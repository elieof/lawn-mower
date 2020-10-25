package io.github.elieof.eoo.mower

import io.github.elieof.eoo.mower.Direction.*

data class LawnMower(
    val position: Position = Position(),
    var direction: Direction = NORTH,
) {
    companion object {
        internal val PATTERN = "([0-9]+) ([0-9]+) ([NEWS])".toRegex()

        /** Retrieve [LawnMower] form string respecting the pattern ([0-9]+) ([0-9]+) ([NEWS]) */
        @JvmStatic
        fun fromString(text: String): LawnMower = PATTERN.matchEntire(text)
            ?.destructured
            ?.let { (x, y, dir) -> LawnMower(Position(x.toInt(), y.toInt()), Direction.from(dir[0])) }
            ?: throw IllegalArgumentException("Lawn mower input ($text) must respect format: ${PATTERN.pattern}")
    }


    /** Run a series of instructions on a lawn mower */
    fun run(top: Position, instructions: List<Instruction>) = instructions.forEach {
        when (it) {
            Instruction.LEFT -> direction = direction.left()
            Instruction.RIGHT -> direction = direction.right()
            Instruction.FORWARD -> forward(top = top)
        }
    }

    /** Move forward following to direction*/
    internal fun forward(top: Position) {
        when (direction) {
            NORTH -> if (position.y < top.y) position.y++
            EAST -> if (position.x < top.x) position.x++
            WEST -> if (position.x > 0) position.x--
            SOUTH -> if (position.y > 0) position.y--
        }
    }

    override fun toString(): String {
        return "$position $direction"
    }
}