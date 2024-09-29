package de.jensklingenberg.example.johnny

import de.jensklingenberg.johnnyfivektwrapper.Board
import de.jensklingenberg.johnnyfivektwrapper.Button
import de.jensklingenberg.johnnyfivektwrapper.onDown
import de.jensklingenberg.johnnyfivektwrapper.onHold
import de.jensklingenberg.johnnyfivektwrapper.onReady


fun ButtonExample() {
    val board = Board()

    board.onReady {

        val button = Button(2)

        button.onDown {
            console.log("DOWN")
        }

        button.onHold {
            console.log("HOLD")
        }

    }
}