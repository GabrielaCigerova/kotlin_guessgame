package org.game
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PlayerTest {
    @Test
    fun testMakeGuess() {
        val player = Player("Toto")
        player.makeGuess{ "56" }
        assertEquals(56, player.lastGuess)
    }
}