package de.jensklingenberg.example.johnny

import de.jensklingenberg.johnnyfivektwrapper.Board
import de.jensklingenberg.johnnyfivektwrapper.Piezo
import de.jensklingenberg.johnnyfivektwrapper.PiezoSong
import de.jensklingenberg.johnnyfivektwrapper.PiezoTune
import de.jensklingenberg.johnnyfivektwrapper.onReady

//http://johnny-five.io/examples/piezo/

fun PiezoSample() {
    val board = Board()
    board.onReady {
        val piezo = Piezo(3)

        val song = arrayOf(
            PiezoSong("C4", 0.25),
            PiezoSong("D4", 0.25),
            PiezoSong("F4", 0.25),
            PiezoSong("D4", 0.25),
            PiezoSong("A4", 0.25),
            PiezoSong(null, 0.25),
            PiezoSong("A4", 1),
            PiezoSong("G4", 1),
            PiezoSong(null, 0.5),
            PiezoSong("C4", 0.25),
            PiezoSong("D4", 0.25),
            PiezoSong("F4", 0.25),
            PiezoSong("D4", 0.25),
            PiezoSong("G4", 0.25),
            PiezoSong(null, 0.25),
            PiezoSong("G4", 1),
            PiezoSong("F4", 1),
            PiezoSong(null, 0.5)
        )

        val tune = PiezoTune(song)

        piezo.play(tune) {
            println("Player")
        }

        val gg = PiezoSong("C4", 0.25)

        val bb = arrayOf(gg)
        val tt = PiezoTune(bb)

        piezo.play(
            tt
        ) {

            println("Player")
        }

    }

}

