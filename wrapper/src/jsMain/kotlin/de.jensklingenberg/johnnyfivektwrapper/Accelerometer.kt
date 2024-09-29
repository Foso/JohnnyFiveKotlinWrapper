package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/accelerometer")
@JsNonModule
open external class Accelerometer {
    constructor(option: AccelerometerGeneralOption)
    constructor(option: AccelerometerAnalogOption)
    constructor(option: AccelerometerMPU6050Option)
    constructor(option: AccelerometerMMA7361Option)

    open var id: String
    open var zeroV: Number
    open var pins: Array<String>
    open var pitch: Number
    open var roll: Number
    open var x: Number
    open var y: Number
    open var z: Number
    open var acceleration: Number
    open var inclination: Number
    open var orientation: Number
    open fun on(event: String /* "change" */, cb: () -> Unit): Accelerometer /* this */
    open fun on(event: String /* "data" */, cb: (freq: Any) -> Unit): Accelerometer /* this */
    open fun hasAxis(name: String)
    open fun enable()
    open fun disable()
}

external interface AccelerometerGeneralOption {
    var controller: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface AccelerometerAnalogOption : AccelerometerGeneralOption {
    var pins: Array<String>
    var sensitivity: Number?
        get() = definedExternally
        set(value) = definedExternally
    var aref: Number?
        get() = definedExternally
        set(value) = definedExternally
    var zeroV: dynamic /* Number? | Array<Number>? */
        get() = definedExternally
        set(value) = definedExternally
    var autoCalibrate: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface AccelerometerMPU6050Option : AccelerometerGeneralOption {
    var sensitivity: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface AccelerometerMMA7361Option : AccelerometerGeneralOption {
    var sleepPin: dynamic /* Number? | String? */
        get() = definedExternally
        set(value) = definedExternally
}


external interface AccelerometerOption {
    var controller: String
}