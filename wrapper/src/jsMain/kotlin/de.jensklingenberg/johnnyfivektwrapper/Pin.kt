package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/pin")
@JsNonModule
open external class Pin {
    constructor(option: Number)
    constructor(option: String)
    constructor(option: PinOption)

    open var id: dynamic /* Number | String */
    open var pin: dynamic /* Number | String */
    open var type: String /* "digital" | "analog" */
    open var value: Number
    open var mode: Number
    open fun query(cb: (pin: PinState) -> Unit)
    open fun high()
    open fun low()
    open fun write(value: Number)
    open fun read(cb: (error: Error, value: Number) -> Unit)
    open fun on(event: String /* "high" | "low" */, cb: () -> Unit): Pin /* this */
    open fun on(event: String /* "data" */, cb: (data: Any) -> Unit): Pin /* this */

    companion object {
        fun write(pin: Number, value: Number)
        fun read(pin: Number, cb: (error: Error, data: Number) -> Unit)
    }
}


external interface PinOption {
    var id: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
    var pin: dynamic /* Number | String */
        get() = definedExternally
        set(value) = definedExternally
    var type: String?
        get() = definedExternally
        set(value) = definedExternally
}


external interface PinState {
    var supportedModes: Array<Number>
    var mode: Number
    var value: Number
    var report: Number
    var analogChannel: Number
}