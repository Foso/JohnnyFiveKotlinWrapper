package de.jensklingenberg.example.johnny

import de.jensklingenberg.johnnyfivektwrapper.Board
import de.jensklingenberg.johnnyfivektwrapper.Led
import de.jensklingenberg.johnnyfivektwrapper.onExit
import de.jensklingenberg.johnnyfivektwrapper.onReady

fun HelloWorld() {
    val LED_BUILTIN = 13
    val board = Board()

    board.onReady {
        println("READY")
        val led = Led(LED_BUILTIN)

        led.blink()

        onExit {
            println("EXIT")
            led.off()
        }
    }
}