package tictactoe

import java.util.*

fun main() {

    val grid = mutableMapOf<String, Char>()

    for (i in 1..3) {
        for (j in 1..3) {
            grid["$i $j"] = ' '
        }
    }

    fun printGrid() {
        println("---------")
        println("| ${grid["1 1"]} ${grid["1 2"]} ${grid["1 3"]} |")
        println("| ${grid["2 1"]} ${grid["2 2"]} ${grid["2 3"]} |")
        println("| ${grid["3 1"]} ${grid["3 2"]} ${grid["3 3"]} |")
        println("---------")
    }

    fun inRange(inputinput: String): Boolean {
        val firstCoordinate: Char = inputinput[0]
        val secondCoordinate: Char = inputinput[1]
        val thirdCoordinate: Char = inputinput[2]
        var result = false
        if (firstCoordinate.isDigit() && secondCoordinate == ' '
            && thirdCoordinate.isDigit() && firstCoordinate in '1'..'3'
            && thirdCoordinate in '1'..'3' || inputinput.length < 3
        ) {
            result = true
        }
        return result
    }

    fun isNum(inputinput: String): Boolean {
        var result = true
        for (i in inputinput) {
            if (!i.isDigit() && i != ' ') {
                result = false
            }
        }
        return result
    }

    fun playerInput(noughtOrCross: Char) {
        val scanner = Scanner(System.`in`)
        print("Enter the coordinates: ")

        val input = scanner.nextLine()
        if (grid[input] == 'X' || grid[input] == 'O') {
            println("This cell is occupied! Choose another one!")
            playerInput(noughtOrCross)
        } else if (input.length < 3 && !isNum(input)) {
            println("You should enter numbers!")
            playerInput(noughtOrCross)
        } else if (input.length < 3) {
            println("Coordinates should be from 1 to 3!")
            playerInput(noughtOrCross)
        } else if (inRange(input)) {
            grid[input] = noughtOrCross
        } else if (!isNum(input)) {
            println("You should enter numbers!")
            playerInput(noughtOrCross)
        } else if (!inRange(input)) {
            println("Coordinates should be from 1 to 3!")
            playerInput(noughtOrCross)
        }
    }

    printGrid()

    fun winOrDraw(xOrO: Char): Boolean {
        var result = false
        when {
            // horizontal
            grid["1 1"] == xOrO && grid["1 2"] == xOrO && grid["1 3"] == xOrO
                    ||
                    grid["2 1"] == xOrO && grid["2 2"] == xOrO && grid["2 3"] == xOrO
                    ||
                    grid["3 1"] == xOrO && grid["3 2"] == xOrO && grid["3 3"] == xOrO
                    ||
                    // vertical
                    grid["1 1"] == xOrO && grid["2 1"] == xOrO && grid["3 1"] == xOrO
                    ||
                    grid["1 2"] == xOrO && grid["2 2"] == xOrO && grid["3 2"] == xOrO
                    ||
                    grid["1 3"] == xOrO && grid["2 3"] == xOrO && grid["3 3"] == xOrO
                    ||
                    // diagonal
                    grid["1 1"] == xOrO && grid["2 2"] == xOrO && grid["3 3"] == xOrO
                    ||
                    grid["1 3"] == xOrO && grid["2 2"] == xOrO && grid["3 1"] == xOrO
            -> {
                println("$xOrO wins")
                result = true
            }
        }
        return result
    }

    for (i in 0..8) {

        if (i % 2 == 0) {
            playerInput('X')
        } else {
            playerInput('O')
        }
        printGrid()
        if (winOrDraw('X') || winOrDraw('O')) {
            return
        }
    }

    println("Draw")

}

