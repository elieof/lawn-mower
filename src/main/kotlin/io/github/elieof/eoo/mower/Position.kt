package io.github.elieof.eoo.mower

data class Position(
    var x: Int = 0,
    var y: Int = 0
) {
    init {
        require(x >= 0) { EXCEPTION_X_NEGATIVE_VALUE }
        require(y >= 0) { EXCEPTION_Y_NEGATIVE_VALUE }
    }

    companion object {
        internal val PATTERN = "([0-9]+) ([0-9]+)".toRegex()
        internal val EXCEPTION_X_NEGATIVE_VALUE = "x position must be positive"
        internal val EXCEPTION_Y_NEGATIVE_VALUE = "y position must be positive"

        /** Retrieve [Position] form string respecting the pattern ([0-9]+) ([0-9]+) ([NEWS]) */
        @JvmStatic
        fun fromString(text: String): Position = PATTERN.matchEntire(text)
            ?.destructured
            ?.let { (x, y) -> Position(x.toInt(), y.toInt()) }
            ?: throw IllegalArgumentException("Lawn mover input ($text) must respect format: ${PATTERN.pattern}")
    }

    override fun toString(): String {
        return "$x $y"
    }
}