package de.jensklingenberg.example.johnny

import de.jensklingenberg.johnnyfivektwrapper.Board
import de.jensklingenberg.johnnyfivektwrapper.RGB
import de.jensklingenberg.johnnyfivektwrapper.onReady

//http://johnny-five.io/examples/led-rainbow/
fun ledRainbow() {
    val board = Board()

    board.onReady {
        val rgb = RGB(arrayOf<Number>(6, 5, 3))
        var index = 0
        val rainbow = arrayOf("FF0000", "FF7F00", "FFFF00", "00FF00", "0000FF", "4B0082", "8F00FF")

        board.loop(1000) {
            index += 1
            println("$index ${rainbow[index]}")
            rgb.color(rainbow[index])
            if (index == rainbow.lastIndex) {
                index = 0
            }
        }
    }
}