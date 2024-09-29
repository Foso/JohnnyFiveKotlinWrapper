package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/sonar")
@JsNonModule
open external class Sonar {
    constructor(option: Number)
    constructor(option: String)
    constructor(option: SonarOption)

    open fun within(range: Array<Number>, cb: () -> Unit)
    open fun within(range: Array<Number>, unit: String, cb: () -> Unit)
    open fun on(event: String /* "change" */, cb: () -> Unit): Sonar /* this */
    open fun on(event: String /* "data" */, cb: (data: Any) -> Unit): Sonar /* this */
}

external interface SonarOption {
    var pin: dynamic /* Number | String */
        get() = definedExternally
        set(value) = definedExternally
    var device: String
    var freq: Number?
        get() = definedExternally
        set(value) = definedExternally
    var threshold: Number?
        get() = definedExternally
        set(value) = definedExternally
}