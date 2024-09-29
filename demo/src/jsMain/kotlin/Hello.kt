import de.jensklingenberg.johnnyfivektwrapper.Board
import de.jensklingenberg.johnnyfivektwrapper.Led
import de.jensklingenberg.johnnyfivektwrapper.onExit
import de.jensklingenberg.johnnyfivektwrapper.onReady

fun main() {
    val LED_BUILTIN = 13
    val board = Board()

    board.onReady {
        println("READY")
        val led = Led(LED_BUILTIN)

        led.blink(5000)

        onExit {
            println("EXIT")
            led.off()
        }
    }
}

//./gradlew jsNodeProductionRun && node ./build/compileSync/js/main/productionExecutable/kotlin/ckotlin