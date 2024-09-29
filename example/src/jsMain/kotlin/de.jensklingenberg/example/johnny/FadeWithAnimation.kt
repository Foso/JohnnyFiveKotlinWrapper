package de.jensklingenberg.example.johnny

import de.jensklingenberg.johnnyfivektwrapper.Board
import de.jensklingenberg.johnnyfivektwrapper.Led
import de.jensklingenberg.johnnyfivektwrapper.onReady
import de.jensklingenberg.johnnyfivektwrapper.utils.jsObject

fun FadeWithAnimation() {
    val board = Board()

    board.onReady {
        val led = Led(11)


        val animationSegment = jsObject {
            easing = "linear"
            duration = 3000
            cuePoints = arrayOf(0.0, 0.2, 0.4, 0.6, 0.8, 1.0)
            keyFrames = arrayOf(0, 10, 0, 50, 0, 255)
            onstop = { console.log("de.jensklingenberg.johnnyfivektwrapper.Animation stopped") }
        }

        led.fade(animationSegment)


        board.wait(12000) {
            led.stop()
            led.off()
        }
    }
}