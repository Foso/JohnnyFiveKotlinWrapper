package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/thermometer")
@JsNonModule
open external class Thermometer(option: ThermometerOption) {
    open var id: String
    open var pin: dynamic /* Number | String */
    open var celsius: Number
    open var fahrenheit: Number
    open var kelvin: Number
    open var C: Number
    open var F: Number
    open var K: Number
    open fun on(event: String /* "change" */, cb: () -> Unit): Thermometer /* this */
    open fun on(event: String /* "data" */, cb: (data: Any) -> Unit): Thermometer /* this */
}

external interface ThermometerOption {
    var controller: String?
        get() = definedExternally
        set(value) = definedExternally
    var pin: dynamic /* String | Number */
        get() = definedExternally
        set(value) = definedExternally
    var toCelsius: ((param_val: Number) -> Number)?
        get() = definedExternally
        set(value) = definedExternally
    var freq: Number?
        get() = definedExternally
        set(value) = definedExternally
}
