package de.jensklingenberg.example.johnny.board

import de.jensklingenberg.johnnyfivektwrapper.Board
import de.jensklingenberg.johnnyfivektwrapper.Led
import de.jensklingenberg.johnnyfivektwrapper.onReady
import de.jensklingenberg.johnnyfivektwrapper.utils.jsObject

fun Repl() {
    val board = Board()
    board.onReady {
        println("Ready event. Repl instance auto-initialized!")
        val led = Led(13)
        board.repl.inject(jsObject {
            on = { led.on() }
            off = { led.off() }
        })
    }
}