package de.jensklingenberg.example.johnny

import de.jensklingenberg.johnnyfivektwrapper.Board
import de.jensklingenberg.johnnyfivektwrapper.Sensor
import de.jensklingenberg.johnnyfivektwrapper.onReady

/**
 * board.on("ready", () => {
 *   const potentiometer = new de.jensklingenberg.johnnyfivektwrapper.Sensor("A3");
 *
 *   potentiometer.on("change", () => {
 *     const {value, raw} = potentiometer;
 *     console.log("de.jensklingenberg.johnnyfivektwrapper.Sensor: ");
 *     console.log("  value  : ", value);
 *     console.log("  raw    : ", raw);
 *     console.log("-----------------");
 *   });
 * });
 */

fun PotentioExample() {
    val board = Board()
    board.onReady {
        val potentiometer = Sensor("A3")

        potentiometer.on("change") {
            val value = potentiometer.value
            val raw = potentiometer.raw
            println("Sensor: ")
            println("  value  : $value")
            println("  raw    : $raw")
            println("-----------------")
        }
    }
}