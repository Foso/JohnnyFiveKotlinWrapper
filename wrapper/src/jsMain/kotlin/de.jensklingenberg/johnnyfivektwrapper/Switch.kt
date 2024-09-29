package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/switch")
@JsNonModule
open external class Switch {
    constructor(option: Number)
    constructor(option: String)
    constructor(option: SwitchOption)

    open var id: String
    open var pin: dynamic /* Number | String */
    open var isClosed: Boolean
    open var isOpen: Boolean
    open fun on(event: String /* "open" | "close" */, cb: () -> Unit): Switch /* this */
}

external interface SwitchOption {
    var pin: dynamic /* Number | String */
        get() = definedExternally
        set(value) = definedExternally
    var type: String? /* "NO" | "NC" */
        get() = definedExternally
        set(value) = definedExternally
}