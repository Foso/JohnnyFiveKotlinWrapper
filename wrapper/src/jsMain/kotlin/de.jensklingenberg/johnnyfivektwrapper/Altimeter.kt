package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/altimeter")
@JsNonModule
open external class Altimeter(option: AltimeterOption) {
    open var id: String
    open var feet: Number
    open var meters: Number
    open fun on(event: String /* "change" */, cb: () -> Unit): Altimeter /* this */
    open fun on(event: String /* "data" */, cb: (data: Any) -> Unit): Altimeter /* this */
}

external interface AltimeterOption {
    var controller: String
    var address: Number?
        get() = definedExternally
        set(value) = definedExternally
    var freq: Number?
        get() = definedExternally
        set(value) = definedExternally
    var elevation: Number?
        get() = definedExternally
        set(value) = definedExternally
}