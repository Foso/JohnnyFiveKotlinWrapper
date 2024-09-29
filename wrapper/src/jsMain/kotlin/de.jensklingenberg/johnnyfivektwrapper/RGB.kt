package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/led/rgb")
@JsNonModule
open external class RGB(pins: Array<Number>) {
    open var red: Led
    open var green: Led
    open var blue: Led
    open var isAnode: Boolean
    open fun on()
    open fun off()
    open fun color(value: String)
    open fun toggle()
    open fun strobe(ms: Number)
    open fun intensity(value: Number)
    open fun fadeIn(ms: Number)
    open fun fadeOut(ms: Number)
    open fun pulse(ms: Number)
    open fun stop(ms: Number)
}

@JsModule("johnny-five/lib/led/rgb")
@JsNonModule
open external class RGBOption {
    var pins: Array<Number>
    var isAnode: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var controller: String?
        get() = definedExternally
        set(value) = definedExternally
}