package de.jensklingenberg.example.johnny.led

import de.jensklingenberg.johnnyfivektwrapper.Board
import de.jensklingenberg.johnnyfivektwrapper.Led

fun PulseExample() {
    val board = Board()


    board.on("ready") {
        val led = Led(13)

        led.pulse()
        board.wait(10000) {
            led.stop()
            led.off()
        }
    }
}