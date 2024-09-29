package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/relay")
@JsNonModule
open external class Relay {
    constructor(option: Number)
    constructor(option: RelayOption)

    open var id: String
    open var pin: dynamic /* Number | String */
    open var isOn: Boolean
    open var type: String
    open fun open()
    open fun close()
    open fun toggle()
}

external interface RelayOption {
    var pin: dynamic /* Number | String */
        get() = definedExternally
        set(value) = definedExternally
    var type: String?
        get() = definedExternally
        set(value) = definedExternally
}