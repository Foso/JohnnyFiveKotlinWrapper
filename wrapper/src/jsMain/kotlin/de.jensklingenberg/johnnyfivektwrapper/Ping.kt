package de.jensklingenberg.johnnyfivektwrapper

open external class Ping {
    constructor(option: Number)
    constructor(option: PingOption)
}

external interface PingOption {
    var pin: dynamic /* Number | String */
        get() = definedExternally
        set(value) = definedExternally
    var freq: Number?
        get() = definedExternally
        set(value) = definedExternally
    var pulse: Number?
        get() = definedExternally
        set(value) = definedExternally
}
