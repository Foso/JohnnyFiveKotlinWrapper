package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/hygrometer")
@JsNonModule
open external class Hygrometer(option: HygrometerOption) {
    open var id: String
    open var relativeHumidity: Number
    open var RH: Number
    open fun on(event: String /* "change" */, cb: () -> Unit): Hygrometer /* this */
    open fun on(event: String /* "data" */, cb: (data: Any) -> Unit): Hygrometer /* this */
}

external interface HygrometerOption {
    var controller: String?
        get() = definedExternally
        set(value) = definedExternally
    var freq: Number?
        get() = definedExternally
        set(value) = definedExternally
}