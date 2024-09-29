package de.jensklingenberg.example.arduino

import de.jensklingenberg.johnnyfivektwrapper.Board
import de.jensklingenberg.johnnyfivektwrapper.Led
import de.jensklingenberg.johnnyfivektwrapper.onExit
import de.jensklingenberg.johnnyfivektwrapper.onReady

fun BlinkTest() {
    val LED_BUILTIN = 13
    val board = Board()

    board.onReady {
        println("READY")
        val led = Led(LED_BUILTIN)

        led.on()

        onExit {
            println("EXIT")
            led.off()
        }
    }
}

private fun myloop(board: Board, led: Led) {
    board.wait(5000) {
        println("FWait")
        led.off()
        board.wait(5000) {
            println("SWAIT")
            led.on()
            myloop(board, led)
        }
    }
}