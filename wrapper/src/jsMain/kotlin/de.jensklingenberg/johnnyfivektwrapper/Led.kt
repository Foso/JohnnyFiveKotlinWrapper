package de.jensklingenberg.johnnyfivektwrapper



/**
 * The Led class constructs objects that represent a single Led attached to the physical board.
 */
@JsModule("johnny-five/lib/led")
@JsNonModule
open external class Led {
    constructor(option: Number)
    constructor(option: LedOption)

    open var id: String
    open var pin: Number
    open fun on()
    open fun off()
    open fun toggle()
    open fun strobe(ms: Number)
    open fun blink()
    open fun blink(ms: Number)
    open fun brightness(param_val: Number)
    open fun fade(brightness: Number, ms: Number)
    open fun fade(animationData: dynamic)

    open fun fadeIn()
    open fun fadeIn(ms: Number)
    open fun fadeOut()
    open fun fadeOut(ms: Number)
    open fun pulse(ms: dynamic)
    open fun pulse()

    open fun stop(ms: Number)
    fun stop()

    interface DigitsOption {
        var pins: Any
        var devices: Number?
            get() = definedExternally
            set(value) = definedExternally
        var controller: String?
            get() = definedExternally
            set(value) = definedExternally
    }

    open class Digits(option: DigitsOption) {
        open var isMatrix: Boolean
        open var devices: Number
        open var digitOrder: Number
        open fun on()
        open fun on(index: Number)
        open fun off()
        open fun off(index: Number)
        open fun clear()
        open fun clear(index: Number)
        open fun brightness(value: Number)
        open fun brightness(index: Number, value: Number)
        open fun draw(position: Number, character: Number)
        open fun draw(index: Number, position: Number, character: Number)
    }

    interface MatrixOption {
        var pins: Any
        var devices: Number?
            get() = definedExternally
            set(value) = definedExternally
    }

    interface MatrixIC2Option {
        var controller: String
        var addresses: Array<Any>?
            get() = definedExternally
            set(value) = definedExternally
        var isBicolor: Boolean?
            get() = definedExternally
            set(value) = definedExternally
        var dims: Any?
            get() = definedExternally
            set(value) = definedExternally
        var rotation: Number?
            get() = definedExternally
            set(value) = definedExternally
    }

    open class Matrix {
        constructor(option: MatrixOption)
        constructor(option: MatrixIC2Option)

        open var isMatrix: Boolean
        open var devices: Number
        open fun on()
        open fun on(index: Number)
        open fun off()
        open fun off(index: Number)
        open fun clear()
        open fun clear(index: Number)
        open fun brightness(value: Number)
        open fun brightness(index: Number, value: Number)
        open fun led(row: Number, col: Number, state: Any)
        open fun led(index: Number, row: Number, col: Number, state: Any)
        open fun row(row: Number, param_val: Number)
        open fun row(index: Number, row: Number, param_val: Number)
        open fun column(row: Number, param_val: Number)
        open fun column(index: Number, row: Number, param_val: Number)
        open fun draw(position: Number, character: Number)
        open fun draw(index: Number, position: Number, character: Number)
    }
}

external interface LedOption {
    var pin: Number
    var type: String?
        get() = definedExternally
        set(value) = definedExternally
    var controller: String?
        get() = definedExternally
        set(value) = definedExternally
    var address: Number?
        get() = definedExternally
        set(value) = definedExternally
    var isAnode: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}
