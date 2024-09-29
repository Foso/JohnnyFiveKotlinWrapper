package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/motion")
@JsNonModule
open external class Motion {
    constructor(option: Number)
    constructor(option: MotionOption)

    open fun on(event: String /* "motionstart" | "motionend" | "calibrated" */, cb: () -> Unit): Motion /* this */
    open fun on(event: String /* "data" */, cb: (data: Any) -> Unit): Motion /* this */
}

external interface MotionOption {
    var pin: dynamic /* Number | String */
        get() = definedExternally
        set(value) = definedExternally
}