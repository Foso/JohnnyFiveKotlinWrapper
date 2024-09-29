package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/board")
@JsNonModule
open external class Board(option: BoardOption = definedExternally) {
    open var io: Any
    open var id: String
    open var repl: Repl
    open var isReady: Boolean
    open var pins: Array<Pin>
    open var port: String
    open fun on(event: String /* "ready" | "connect" */, cb: (dynamic) -> Unit): Board /* this */

    /**
     * Set the mode of a specific pin, one of INPUT, OUTPUT, ANALOG, PWM, SERVO. Mode constants are exposed via the de.jensklingenberg.johnnyfivektwrapper.Pin class
     */
    open fun pinMode(pin: Number, mode: Number)

    /**
     * Set the mode of a specific pin, one of INPUT, OUTPUT, ANALOG, PWM, SERVO. Mode constants are exposed via the de.jensklingenberg.johnnyfivektwrapper.Pin class
     */
    open fun pinMode(pin: String, mode: Number)
    open fun analogWrite(pin: Number, value: Number)
    open fun analogWrite(pin: String, value: Number)

    /**
     * Register a handler to be called whenever the board reports the voltage value (0-1023) of the specified analog pin.
     */
    open fun analogRead(pin: Number, cb: (item: Number) -> Unit)
    open fun analogRead(pin: String, cb: (item: Number) -> Unit)

    /**
     * Write a digital value (0 or 1) to a digital pin.
     */
    open fun digitalWrite(pin: Number, value: Number)
    open fun digitalWrite(pin: String, value: Number)
    open fun digitalRead(pin: Number, cb: (item: Number) -> Unit)
    open fun digitalRead(pin: String, cb: (item: Number) -> Unit)
    open fun servoWrite(pin: Number, angle: Number)
    open fun servoWrite(pin: String, angle: Number)

    open fun shiftOut(dataPin: Pin, clockPin: Pin, isBigEndian: Boolean, value: Number)

    /**
     * Register a handler to be called once in another execution turn and after milliseconds has elapsed.
     */
    open fun wait(ms: Number, cb: () -> Unit)

    /**
     * Register a handler to be called repeatedly, in another execution turn, every milliseconds period.
     * handler recieves one argument which is a function that will cancel the loop if called.
     */
    open fun loop(ms: Number, cb: () -> Unit)
    open fun samplingInterval(ms: Number)
}

external interface BoardOption {
    var id: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var port: dynamic /* String? | Any? */
        get() = definedExternally
        set(value) = definedExternally
    var repl: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var debug: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var timeout: Number?
        get() = definedExternally
        set(value) = definedExternally
    var io: Any?
        get() = definedExternally
        set(value) = definedExternally
}

fun Board.onConnect(cb: Board.() -> Unit) {
    this.on("connect") {
        this.cb()
    }
}

fun Board.onReady(cb: Board.() -> Unit) {
    this.on("ready") {
       this.cb()
    }
}

fun Board.onInfo(cb: Board.(event:dynamic) -> Unit) {
    this.on("info") {
        this.cb(it)
    }
}

fun Board.onWarn(cb: Board.(event:dynamic) -> Unit) {
    this.on("warn") {
        this.cb(it)
    }
}

fun Board.onFail(cb: Board.(event:dynamic) -> Unit) {
    this.on("fail") {
        this.cb(it)
    }
}

fun Board.onMessage(cb: Board.(event:dynamic) -> Unit) {
    this.on("message") {
        this.cb(it)
    }
}

fun Board.onExit(cb: Board.() -> Unit) {
    this.on("exit") {
        this.cb()
    }
}

enum class PinMode
{
    INPUT,
    OUTPUT,
    ANALOG,
    PWM,
    SERVO
}

/**
 * Set the mode of a specific pin, one of INPUT, OUTPUT, ANALOG, PWM, SERVO. Mode constants are exposed via the de.jensklingenberg.johnnyfivektwrapper.Pin class
 */
fun Board.pinMode(pin: Number, mode: PinMode) {
    this.pinMode(pin, mode.ordinal)
}