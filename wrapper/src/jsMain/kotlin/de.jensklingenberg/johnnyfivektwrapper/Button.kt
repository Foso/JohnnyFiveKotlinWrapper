package de.jensklingenberg.johnnyfivektwrapper


@JsModule("johnny-five/lib/button")
@JsNonModule
open external class Button {
    constructor(pin: Number)
    constructor(pin: String)
    constructor(pin: ButtonOption)

    open var id: String
    open var pin: dynamic /* Number | String */
    open var downValue: Number
    open var upValue: Number
    open var holdtime: Number

    // open fun on(event: String /* "down" | "press" | "up" | "release" */, cb: () -> Unit): Button /* this */
    open fun on(event: String /* "hold" */, cb: (holdTime: Number) -> Unit): Button /* this */
}

fun Button.onHold(cb: (holdTime: Number) -> Unit): Button {
    return on("hold") { holdTime -> cb(holdTime) }
}

fun Button.onDown(cb: Button.() -> Unit): Button {
    return on("down") { cb() }
}

fun Button.onPress(cb: Button.() -> Unit): Button {
    return on("press") { cb() }
}

fun Button.onUp(cb: Button.() -> Unit): Button {
    return on("up") { cb() }
}

fun Button.onRelease(cb: Button.() -> Unit): Button {
    return on("release") { cb() }
}

external interface ButtonOption {
    var pin: dynamic /* Number | String */
        get() = definedExternally
        set(value) = definedExternally
    var invert: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var isPullup: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var isPulldown: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var holdtime: Number?
        get() = definedExternally
        set(value) = definedExternally
}
