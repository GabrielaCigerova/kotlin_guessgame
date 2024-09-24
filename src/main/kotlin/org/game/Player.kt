package org.game

class Player (var name:String) {
    var score: Int = 0
    var lastGuess: Float? = 0F

    fun makeGuess(getInput: () -> String?) {
        var validInput = false
        while (!validInput) {
            println("Write your guess: ")
            val playerInput = getInput()?.trim()
            if (playerInput.isNullOrEmpty()) {
                println("Input cannot be null or empty. Please enter a valid number.")
                continue
            }
            val input = playerInput.replace(",", ".")

            if (input.count { it == '.' } > 1) {
                println("Invalid input. Please enter a NUMBER with a single decimal point.")
                continue
            }
            try {
                lastGuess = input.toFloat()
                validInput = true
            } catch (e: NumberFormatException) {
                println("Invalid input. Please enter a NUMBER.")
            }
        }
    }
}

