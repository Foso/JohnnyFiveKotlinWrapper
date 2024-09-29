package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/motor")
@JsNonModule
open external class Motor {
    constructor(option: Array<Number>)
    constructor(option: MotorOption)

    open var isOn: Boolean
    open fun forward(speed: Number)
    open fun fwd(speed: Number)
    open fun reverse(speed: Number)
    open fun rev(speed: Number)
    open fun start(speed: Number = definedExternally)
    open fun stop()
    open fun brake()
    open fun release()
}

external interface MotorOption {
    var pins: MotorPins
    var current: SensorOption?
        get() = definedExternally
        set(value) = definedExternally
    var invertPWM: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var address: Number?
        get() = definedExternally
        set(value) = definedExternally
    var controller: String?
        get() = definedExternally
        set(value) = definedExternally
    var register: Any?
        get() = definedExternally
        set(value) = definedExternally
    var bits: Any?
        get() = definedExternally
        set(value) = definedExternally
}

external open class Motors {
    constructor(option: Array<Number>)
    constructor(option: Array<MotorOption>)

    open var isOn: Boolean
    open fun forward(speed: Number)
    open fun fwd(speed: Number)
    open fun reverse(speed: Number)
    open fun rev(speed: Number)
    open fun start(speed: Number = definedExternally)
    open fun stop()
    open fun brake()
    open fun release()
}

external interface MotorPins {
    var pwm: Number
    var dir: Number
    var cdir: Number?
        get() = definedExternally
        set(value) = definedExternally
    var brake: Number?
        get() = definedExternally
        set(value) = definedExternally
}