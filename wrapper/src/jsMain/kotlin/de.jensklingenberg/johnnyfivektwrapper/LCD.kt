package de.jensklingenberg.johnnyfivektwrapper


@JsModule("johnny-five/lib/lcd")
@JsNonModule
open external class LCD {
    constructor(option: LCDGeneralOption)
    constructor(option: LCDI2COption)
    constructor(option: LCDParallelOption)

    open var id: String
    open var rows: Number
    open var cols: Number
    open fun print(message: String): LCD /* this */
    open fun useChar(char: String): LCD /* this */
    open fun clear(): LCD /* this */
    open fun cursor(row: Number, col: Number): LCD /* this */
    open fun home(): LCD /* this */
    open fun on(): LCD /* this */
    open fun off(): LCD /* this */
    open fun display(): LCD /* this */
    open fun noDisplay(): LCD /* this */
    open fun blink(): LCD /* this */
    open fun noBlink(): LCD /* this */
    open fun autoscroll(): LCD /* this */
    open fun noAutoscroll(): LCD /* this */
    open fun bgColor(color: Any): LCD /* this */
    open fun noBacklight(): LCD /* this */
    open fun backlight(): LCD /* this */
}

external interface LCDGeneralOption {
    var rows: Number?
        get() = definedExternally
        set(value) = definedExternally
    var cols: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface LCDI2COption : LCDGeneralOption {
    var controller: String
    var backlight: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface LCDParallelOption : LCDGeneralOption {
    var pins: Array<Any>
    var backlight: Number?
        get() = definedExternally
        set(value) = definedExternally
}