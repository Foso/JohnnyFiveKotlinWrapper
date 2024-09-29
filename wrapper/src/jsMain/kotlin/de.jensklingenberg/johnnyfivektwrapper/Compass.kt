package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/compass")
@JsNonModule
open external class Compass(option: CompassOption) {
    open var heading: Number
    open var bearing: Bearing
    open fun on(event: String /* "change" */, cb: () -> Unit): Compass /* this */
    open fun on(event: String /* "data" */, cb: (data: Any) -> Unit): Compass /* this */
}

external interface CompassOption {
    var controller: String
    var gauss: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Bearing {
    var name: String
    var abbr: String
    var low: Number
    var high: Number
    var heading: Number
}
