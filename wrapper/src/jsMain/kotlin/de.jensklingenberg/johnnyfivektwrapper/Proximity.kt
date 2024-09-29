package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/proximity")
@JsNonModule
open external class Proximity {
    constructor(option: Number)
    constructor(option: ProximityOption)

    open fun on(event: String /* "change" */, cb: () -> Unit): Proximity /* this */
    open fun on(event: String /* "data" */, cb: (data: ProximityData) -> Unit): Proximity /* this */
}

external interface ProximityOption {
    var pin: dynamic /* Number | String */
        get() = definedExternally
        set(value) = definedExternally
    var controller: String
    var freq: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ProximityData {
    var cm: Number
    var `in`: Number
}