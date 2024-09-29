package de.jensklingenberg.johnnyfivektwrapper


@JsModule("johnny-five/lib/gyro")
@JsNonModule
open external class Gyro {
    constructor(option: GyroGeneralOption)
    constructor(option: GyroAnalogOption)
    constructor(option: GyroMPU6050Option)

    open var id: String
    open var pins: Array<String>
    open var isCalibrated: Boolean
    open var pitch: Any
    open var roll: Any
    open var yaw: Any
    open var rate: Any
    open var x: Number
    open var y: Number
    open var z: Number
    open fun on(event: String /* "change" */, cb: () -> Unit): Gyro /* this */
    open fun on(event: String /* "data" */, cb: (data: Any) -> Unit): Gyro /* this */
    open fun recalibrate()
}

external interface GyroGeneralOption {
    var controller: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface GyroAnalogOption : GyroGeneralOption {
    var pins: Array<String>
    var sensitivity: Number
    var resolution: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface GyroMPU6050Option : GyroGeneralOption {
    var sensitivity: Number
}