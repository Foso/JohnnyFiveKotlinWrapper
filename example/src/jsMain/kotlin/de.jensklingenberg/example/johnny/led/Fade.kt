package de.jensklingenberg.example.johnny.led

import de.jensklingenberg.johnnyfivektwrapper.Board
import de.jensklingenberg.johnnyfivektwrapper.Led

/**
 * const { Board, Led } = require("johnny-five");
 * const board = new Board();
 *
 * board.on("ready", () => {
 *   const led = new Led(11);
 *
 *   led.fadeIn();
 *
 *   // Toggle the led after 5 seconds (shown in ms)
 *   board.wait(5000, () => {
 *     led.fadeOut();
 *   });
 * });
 */
fun FadeExample() {
    val board = Board()
    board.on("ready") {
        val led = Led(11)

        led.fadeIn()
        board.wait(5000) {
            led.fadeOut()
        }
    }
}