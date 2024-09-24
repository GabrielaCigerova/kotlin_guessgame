package org.game

import kotlin.math.abs

class Game(
    val numberOfPlayers: Int,
    val players: List<Player>,
    val hints : List<Hint>,
    var currentRound: Int = 1,
    val winningScore: Int? = 3) // this makes winning score set by default to three if not set up differently
{
    fun playRound() {
        println("--------| Round $currentRound |--------")

        if (currentRound == 1) {
            println("How to play --> Guess the number. Closest number to the correct answer wins a point.")
        }
        val hint = getRandomHint()
        if (hint != null) {
            println("Category: ${hint.hintCategory}")
            println("Hint: ${hint.hintText}")

            for (player in players) {
                playerGuess(player)
            }

            val winner = getWinner(hint)
            if (winner != null) {
                winner.score += 1
                println("Winner of this round is ${winner.name}")
                println("---------------------------------------")
                println("${hint.funnyText}")
                println("Correct answer was ${formatAnswer(hint.correctAnswer)}")
                println("---------------------------------------")
            } else {
                println("No winner.")
            }
        } else {
            println("No hints left! The game is over.")
            return
        }
        currentRound += 1
    }

    fun playerGuess(player: Player) {
        println("Hey, ${player.name}. It's your turn.")
        player.makeGuess { readLine() }
    }

    fun guessDifference(player: Player, correctAnswer: Float): Float {
        val guess = player.lastGuess?: Float.MAX_VALUE
        val diff = abs(guess - correctAnswer)
        return diff
    }

    fun getWinner(hint : Hint): Player? {
        val correctAnswer = hint.correctAnswer
        var winner : Player? = null
        var x : Float = Float.MAX_VALUE

        for(player in players){
            val diff = guessDifference(player, correctAnswer)
            if(diff < x){
                x = diff
                winner = player
            }
        }
        return winner
    }

    fun checkForWinner(array: MutableList<Player>): Boolean {
        for(player in array){
            if (player.score == winningScore){
                return true
            }
        }
        return false
    }

    fun formatAnswer(answer: Float): String {
        return if (answer % 1.0f == 0.0f) {
            answer.toInt().toString()
        } else {
            answer.toString()
        }
    }

    fun showScore(array: MutableList<Player>) {
        var x = 1
        array.sortByDescending { it.score }
        println("----- Scoreboard: -----")
        for (player in array) {
            println("$x. ${player.name} -> ${player.score} point/s")
            x++
        }
        println("-----------------------")
    }

    fun showFinalScore(array: MutableList<Player>) {
        var x = 1
        array.sortByDescending { it.score }
        println("----- Scoreboard: -----")
        for (player in array) {
            if (x==1){
                println("*** WINNER *** is ${player.name}")
            }
            println("$x. ${player.name} -> ${player.score} point/s")
            x++
        }
        println("-----------------------")
        println("Thank you for playing!")
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



