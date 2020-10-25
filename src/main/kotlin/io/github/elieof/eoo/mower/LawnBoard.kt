package io.github.elieof.eoo.mower

import java.io.File

class LawnBoard(fileName: String = "src/main/resources/board.txt") {
    private val lines: List<String>

    companion object {
        const val EXCEPTION_BLANK = "fileName cannot be Blank!"
        const val EXCEPTION_INVALID_FILE = "invalid file"
    }

    /** Load all lines and check file
     */
    init {
        lines = mutableListOf()
        require(fileName.isNotBlank()) { EXCEPTION_BLANK }
        File(fileName).useLines { lines.addAll(it) }
        require((lines.size - 1) % 2 == 0) { EXCEPTION_INVALID_FILE }
    }

    /** run instructions using the lines form the files
     * @return the list of mower in their final position on the lawn
     */
    fun run(): List<LawnMower> {
        val mowers: MutableList<LawnMower> = mutableListOf()
        val top: Position = Position.fromString(lines[0])

        for (i in 1..lines.size - 2 step 2) {
            val mower = LawnMower.fromString(lines[i])
            mower.run(top, Instruction.fromString(lines[i + 1]))
            mowers.add(mower)
        }

        return mowers
    }
}