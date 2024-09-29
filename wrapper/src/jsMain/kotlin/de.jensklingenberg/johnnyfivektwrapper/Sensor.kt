package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/sensor")
@JsNonModule
open external class Sensor {
    constructor(option: Number)
    constructor(option: String)
    constructor(option: SensorOption)

    open var id: String
    open var pin: dynamic /* Number | String */
    open var threshold: Number
    open var boolean: Boolean
    open var raw: Number
    open var analog: Number
    open var constrained: Number
    open var value: Number
    open fun scaleTo(low: Number, high: Number): Number
    open fun fscaleTo(low: Number, high: Number): Number
    open fun scaleTo(range: Array<Number>): Number
    open fun fscaleTo(range: Array<Number>): Number
    open fun booleanAt(barrier: Number): Boolean
    open fun within(range: Array<Number>, cb: () -> Unit)
    open fun on(event: String /* "data" */, cb: (data: Any) -> Unit): Sensor /* this */
}

external interface SensorOption {
    var pin: dynamic /* Number | String */
        get() = definedExternally
        set(value) = definedExternally
    var freq: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var threshold: Number?
        get() = definedExternally
        set(value) = definedExternally
    var enabled: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}