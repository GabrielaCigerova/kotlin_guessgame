package org.game

class Game(
    val numberOfPlayers: Int,
    val players: List<Player>,
    var currentRound: Int = 1,
    val winningScore: Int? = 3) // this makes winning score set by default to three if not set up differently
{
    fun playRound() {
        println("Round $currentRound")
        println("Guess the number. Closest number to the correct answer wins a point.")

        val hint = getRandomHint()
        if (hint != null) {
            println("Category: ${hint.hintCategory}")
            println("Hint: ${hint.hintText}")

                for (player in players) {
                    playerGuess(player)
                }
            } else {
                println("Gaby, there is a problem with DB.")
            }
        currentRound += 1
        }

    fun playerGuess(player: Player) {
        println("Hey, ${player.name}. It's your turn.")
        player.makeGuess { readLine() }
    }

    }

fun setNumberOfPlayers(getInput: () -> String?): Int {
    var validInput = false
    var numberPlayers = 0
    while (!validInput) {
        print("Enter your number of players:")
        val input = getInput()
        try {
            if (input!=null) {
                numberPlayers = input.toInt()
                if (numberPlayers > 0) {
                    validInput = true
                } else {
                    println("Number of players must be greater than 0. Please try again.")
                }
            } else {
                println("Input cannot be null. Please enter a valid number.")
            }
        } catch (e: NumberFormatException) {
            println("Invalid input. Please enter a NUMBER.")
        }
    }
    return numberPlayers
}

