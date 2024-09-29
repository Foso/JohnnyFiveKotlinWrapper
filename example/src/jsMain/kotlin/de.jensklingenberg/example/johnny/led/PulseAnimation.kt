package de.jensklingenberg.example.johnny.led

import de.jensklingenberg.johnnyfivektwrapper.Board
import de.jensklingenberg.johnnyfivektwrapper.Led
import de.jensklingenberg.johnnyfivektwrapper.onReady
import de.jensklingenberg.johnnyfivektwrapper.utils.jsObject

/**
 * const { Board, Led } = require("johnny-five");
 * const board = new Board();
 *
 * board.on("ready", () => {
 *   // Create a standard `led` component
 *   // on a valid pwm pin
 *   const led = new Led(11);
 *
 *   // Instead of passing a time and rate, you can
 *   // pass any valid de.jensklingenberg.johnnyfivektwrapper.Animation() segment opts object
 *   // https://github.com/rwaldron/johnny-five/wiki/de.jensklingenberg.johnnyfivektwrapper.Animation#segment-properties
 *   led.pulse({
 *     easing: "linear",
 *     duration: 3000,
 *     cuePoints: [0, 0.2, 0.4, 0.6, 0.8, 1],
 *     keyFrames: [0, 10, 0, 50, 0, 255],
 *     onstop() {
 *       console.log("de.jensklingenberg.johnnyfivektwrapper.Animation stopped");
 *     }
 *   });
 *
 *   // Stop and turn off the led pulse loop after
 *   // 12 seconds (shown in ms)
 *   board.wait(12000, () => {
 *
 *     // stop() terminates the interval
 *     // off() shuts the led off
 *     led.stop().off();
 *   });
 * });
 */

fun PulseWithAnimation() {
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

        led.pulse(animationSegment)

        wait(12000) {
            led.stop()
            led.off()
        }
    }
}