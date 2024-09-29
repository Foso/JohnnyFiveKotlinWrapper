package de.jensklingenberg

import de.jensklingenberg.johnnyfivektwrapper.Board
import de.jensklingenberg.johnnyfivektwrapper.Led
import kotlin.js.Date

fun LaufLicht() {

    val board = Board()



    board.on("ready") {
        val zeitProLED = 200

        var aktuelleLED = 0;
        var letzterWechsel = 0.0;

        val LEDPins = listOf(Led(2), Led(3), Led(4))
        // LEDPins[0].on()

        board.loop(1000) {
            val aktuelleZeit = Date.now()
            if (aktuelleZeit - letzterWechsel > zeitProLED) {
                LEDPins[aktuelleLED].off()
                aktuelleLED = (aktuelleLED + 1) % 3;

                LEDPins[aktuelleLED].on()
                letzterWechsel = aktuelleZeit;
            }


        }

    }

}