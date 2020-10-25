package io.github.elieof.eoo.mower

enum class Instruction(private val value: Char) {
    LEFT('G'),
    RIGHT('D'),
    FORWARD('A');

    companion object {
        internal val PATTERN = "([ADG]+)".toRegex()

        internal val EXCEPTION_NOT_FOUND = "Direction not found"

        private val VALUES: Map<Char, Instruction> = values().associateBy { it.value }

        @JvmStatic
        fun from(value: Char): Instruction =
            VALUES[value] ?: throw java.lang.IllegalArgumentException(Direction.EXCEPTION_NOT_FOUND)

        /** Retrieve Instruction list form string respecting the pattern ([ADG]+) */
        @JvmStatic
        fun fromString(text: String): List<Instruction> {
            return PATTERN.matchEntire(text)
                ?.value?.toCharArray()?.map { from(it) }
                ?: throw IllegalArgumentException("Instruction input ($text) must respect format: ${PATTERN.pattern}")
        }
    }

    override fun toString(): String = value.toString()
}