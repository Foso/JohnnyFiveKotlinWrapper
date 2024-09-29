package de.jensklingenberg.example.johnny.board

import de.jensklingenberg.johnnyfivektwrapper.Board
import de.jensklingenberg.johnnyfivektwrapper.BoardOption
import de.jensklingenberg.johnnyfivektwrapper.onExit
import de.jensklingenberg.johnnyfivektwrapper.onMessage
import de.jensklingenberg.johnnyfivektwrapper.onReady

fun BoardWithPort() {
    // Johnny-Five will try its hardest to detect the port for you,
    // however you may also explicitly specify the port by passing
    // it as an optional property to the Board constructor:
    val board = Board(object : BoardOption {
        override var port: dynamic = "/dev/cu.usbmodem1411"
    })

    board.onMessage {
        println("INFO: ${it.message}")
    }

    // The board's pins will not be accessible until
    // the board has reported that it is ready
    board.onReady {
        board.pinMode("13", 1)

        board.loop(500) {
            // Whatever the last value was, write the opposite
            board.digitalWrite(13, if (board.pins[13].value == 1) 0 else 1)
        }

        onExit {
            board.digitalWrite(13, 0)
        }
    }
}