package de.jensklingenberg.example.johnny

import de.jensklingenberg.johnnyfivektwrapper.Board
import de.jensklingenberg.johnnyfivektwrapper.Led
import de.jensklingenberg.johnnyfivektwrapper.onReady

data class SequenceStep(val method: (Led) -> Unit, val duration: Int)


//http://johnny-five.io/examples/led-demo-sequence/
fun ledDemoSeq() {
    val board = Board()

    // Do we want the sequence to loop?
    val loop = true

    // Create a simple demo sequece that calls various
    // Led methods with specified arguments and
    // let it run for the given duration (defaults to 3 seconds).
    val demoSequence = listOf(
        SequenceStep({ led -> led.pulse(1000) }, 5000),
        SequenceStep({ led -> led.strobe(500) }, 3000),
        SequenceStep({ led -> led.fadeIn(2000) }, 2500),
        SequenceStep({ led -> led.fadeOut(5000) }, 5500),
        SequenceStep({ led -> led.brightness(10) }, 3000),
        SequenceStep({ led -> led.off() }, 3000),
    )

    // Execute a method in the demo sequence
    fun execute(led: Led, step: Int) {
        // Increment the step
        var nexStep = step + 1
        val duration = demoSequence[step].duration
        demoSequence[step].method(led)

        // If we're at the end, start over (loop==true) or exit
        if (nexStep == demoSequence.size) {
            if (loop) {
                nexStep = 0
            } else {
                // We're done!
                js("process.exit(0)")
            }
        }

        // Recursively call the next step after specified duration
        board.wait(duration) {
            execute(led, nexStep);
        }
    }

    board.onReady {
        // Defaults to pin 11 (must be PWM)
        val led = Led(11)
        // Kick off the first step
        execute(led, 0);
    }

}