package de.jensklingenberg

import de.jensklingenberg.johnnyfivektwrapper.Board
import de.jensklingenberg.johnnyfivektwrapper.Led
import de.jensklingenberg.johnnyfivektwrapper.Piezo
import kotlin.js.Date


fun map(fromVoltage: Int, fromLow: Int, fromHigh: Int, toLow: Int, toHigh: Int): Int {
    return (fromVoltage - fromLow) * (toHigh - toLow) / (fromHigh - fromLow) + toLow;
}

fun Theremin() {
    var HIGH = 1
    var LOW = 0
    val board = Board()
    var low = 1023;
    var high = 0;
    val LED_BUILTIN = 13

    var pitch: Int = 0;
    var calibrated = false;

    board.on("ready") {

        var piezo = Piezo(8)
        var led = Led(LED_BUILTIN)
        var start = Date().getTime()

        board.analogRead(0) { voltage ->
            if (calibrated) {
                board.digitalWrite(13, 0)
                return@analogRead
            }

            if (voltage.toInt() > high) {
                high = voltage.toInt()
            }

            if (voltage.toInt() < high) {
                low = voltage.toInt()
            }

            board.digitalWrite(LED_BUILTIN, HIGH)
        }

        board.wait(5000) {
            calibrated = true

            board.analogRead(0) { voltage ->
                pitch = map(voltage.toInt(), low, high, 50, 4000)
                piezo.tone(pitch, 20)
            }
        }

    }
}