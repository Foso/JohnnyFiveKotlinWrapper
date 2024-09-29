package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/esc")
@JsNonModule
open external class ESC {
    constructor(option: Number)
    constructor(option: String)
    constructor(option: ESCOption)

    open var id: String
    open var pin: dynamic /* Number | String */
    open var pwmRange: Array<Number>
    open var value: Number
    open fun throttle(value: Number): ESC /* this */
    open fun brake(): ESC /* this */

    companion object {
        var Collection: ESCs
    }
}

open external class ESCs(option: Array<Any /* Number | String | ESCOption */>) : Collection<ESC> {
    open fun throttle(value: Number): ESCs /* this */
    open fun brake(): ESCs /* this */
}

external interface ESCOption {
    var pin: dynamic /* Number | String */
        get() = definedExternally
        set(value) = definedExternally
    var pwmRange: Array<Number>?
        get() = definedExternally
        set(value) = definedExternally
    var address: String?
        get() = definedExternally
        set(value) = definedExternally
    var controller: String? /* "PCA9685" | "DEFAULT" */
        get() = definedExternally
        set(value) = definedExternally
    var device: String? /* "FORWARD" | "FORWARD_REVERSE" | "FORWARD_REVERSE_BRAKE" */
        get() = definedExternally
        set(value) = definedExternally
    var neutral: Number?
        get() = definedExternally
        set(value) = definedExternally
}