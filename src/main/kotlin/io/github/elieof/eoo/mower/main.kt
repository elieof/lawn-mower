package io.github.elieof.eoo.mower

fun main(args: Array<String>) {

    require(args.size <= 1) { "Provide only file path parameter" }
    val fileName = if (args.isEmpty()) {
        println("Using default file in resources!")
        val defaultFile = "src/main/resources/board.txt"
        defaultFile
    } else args[0]

    LawnBoard(fileName).run().forEach { println(it) }
}

