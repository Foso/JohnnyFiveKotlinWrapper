package de.jensklingenberg.example.johnny

import de.jensklingenberg.johnnyfivektwrapper.Board
import de.jensklingenberg.johnnyfivektwrapper.Servo
import de.jensklingenberg.johnnyfivektwrapper.Servos
import de.jensklingenberg.johnnyfivektwrapper.onReady

fun ServoExample() {
    val board = Board()
    board.onReady {
        val servo = Servos(listOf(Servo(10)))
        servo.min()
        servo.to(90, 5000)

    }
}

