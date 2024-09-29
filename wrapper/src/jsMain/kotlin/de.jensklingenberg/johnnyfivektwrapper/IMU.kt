package de.jensklingenberg.johnnyfivektwrapper


open external class IMU {
    constructor(option: IMUGeneralOption)
    constructor(option: IMUMPU6050Option)

    open var accelerometer: Accelerometer
    open var compass: Compass
    open var gyro: Gyro
    open var orientation: Orientation
    open var thermometer: Thermometer
    open fun on(event: String /* "change" | "calibrated" */, cb: () -> Unit): IMU /* this */
    open fun on(event: String /* "data" */, cb: (data: Any) -> Unit): IMU /* this */
}

external interface IMUGeneralOption {
    var controller: String?
        get() = definedExternally
        set(value) = definedExternally
    var freq: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface IMUMPU6050Option : IMUGeneralOption {
    var address: Number
}