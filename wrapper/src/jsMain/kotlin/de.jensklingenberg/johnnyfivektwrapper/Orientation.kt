package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/orientation")
@JsNonModule
open external class Orientation(option: OrientationOption) {
    open var euler: Any
    open var quarternion: Any
    open fun on(event: String /* "change" | "calibrated" */, cb: () -> Unit): Orientation /* this */
    open fun on(event: String /* "data" */, cb: (data: Any) -> Unit): Orientation /* this */
}

external interface OrientationOption {
    var controller: String?
        get() = definedExternally
        set(value) = definedExternally
    var freq: Number?
        get() = definedExternally
        set(value) = definedExternally
}