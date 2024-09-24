package org.game

fun main(args : Array<String>) {
    generateHints()
    val numberOfPlayers = setNumberOfPlayers({ readLine() })
    val players = mutableListOf<Player>()

    for (i in 1..numberOfPlayers) {
        println("Hello, player n.$i! What's your name?")
        val input = readLine()?.trim().toString()
        val playerName = if (input.isBlank()) {
            "Potato $i"
        } else {
            input
        }
        players.add(Player(playerName))
    }

    println("Players for this game:")
    for (player in players) {
        println(player.name)
    }
    println("Let's play!")

    val game = Game(numberOfPlayers, players, hintDatabase)
    while (!game.checkForWinner(players)) {
        game.playRound()
        game.showScore(players)
    }
    game.showFinalScore(players)
}

