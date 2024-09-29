package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/stepper")
@JsNonModule
open external class Stepper {
    constructor(option: Number)
    constructor(option: String)
    constructor(option: StepperOption)

    open fun step(stepsOrOpts: Any, cb: () -> Unit)
    open fun rpm(): Stepper
    open fun rpm(value: Number): Stepper
    open fun speed(): Stepper
    open fun speed(value: Number): Stepper
    open fun direction(): Stepper
    open fun direction(value: Number): Stepper
    open fun accel(): Stepper
    open fun accel(value: Number): Stepper
    open fun decel(): Stepper
    open fun decel(value: Number): Stepper
    open fun cw(): Stepper
    open fun ccw(): Stepper
    open fun within(range: Array<Number>, cb: () -> Unit)
    open fun within(range: Array<Number>, unit: String, cb: () -> Unit)
    open fun on(event: String /* "change" */, cb: () -> Unit): Stepper /* this */
    open fun on(event: String /* "data" */, cb: (data: Any) -> Unit): Stepper /* this */
    open class TYPE {
        companion object {
            var DRIVER: Number
            var TWO_WIRE: Number
            var FOUR_WIRE: Number
        }
    }
}

external interface StepperOption {
    var pins: Any
    var stepsPerRev: Number
    var type: Number
    var rpm: Number?
        get() = definedExternally
        set(value) = definedExternally
    var direction: Number?
        get() = definedExternally
        set(value) = definedExternally
}