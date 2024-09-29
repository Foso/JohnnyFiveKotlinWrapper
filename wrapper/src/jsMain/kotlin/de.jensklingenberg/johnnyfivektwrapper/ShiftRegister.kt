package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/shift-register")
@JsNonModule
open external class ShiftRegister(option: ShiftRegisterOption) {
    open var id: String
    open var pins: Any
    open var value: Any
    open var isAnode: Boolean
    open fun clear()
    open fun display(number: Number)
    open fun display(number: String)
    open fun reset()
    open fun send(vararg value: Number)
}

external interface ShiftRegisterOption {
    var pins: Any
    var isAnode: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

