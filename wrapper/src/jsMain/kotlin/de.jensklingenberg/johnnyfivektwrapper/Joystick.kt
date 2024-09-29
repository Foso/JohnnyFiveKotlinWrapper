package de.jensklingenberg.johnnyfivektwrapper

import kotlin.js.Date

@JsModule("johnny-five/lib/joystick")
@JsNonModule
open external class Joystick(option: JoystickOption) {
    open var id: String
    open var x: Number
    open var y: Number
    open var axis: Array<Number>
    open var raw: Array<Number>
    open fun on(event: String /* "change" */, cb: () -> Unit): Joystick /* this */
    open fun on(event: String /* "data" */, cb: (data: Any) -> Unit): Joystick /* this */
    open fun on(event: String /* "axismove" */, cb: (error: Error, date: Date) -> Unit): Joystick /* this */
}

external interface JoystickOption {
    var pins: Array<String>
    var invert: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var invertX: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var invertY: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}