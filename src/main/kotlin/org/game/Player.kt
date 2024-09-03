package org.game

class Player (var name:String) {
    var score: Int = 0
    var lastGuess: Float? = 0F

    fun makeGuess(getInput: () -> String?) {
        var validInput = false
        while (!validInput) {
            println("Write your guess: ")
            val playerInput = getInput()?.replace(",", ".")
            try {
                if (playerInput != null) {
                    lastGuess = playerInput.trim().toFloat()
                    validInput = true
                } else {
                    println("Input cannot be null. Please enter a valid number.")
                }
            } catch (e: NumberFormatException) {
                println("Invalid input. Please enter a NUMBER.")
            }
        }
    }
}

