package de.jensklingenberg.johnnyfivektwrapper


/**
 * The Servo class constructs objects that represent a single Servo attached to the physical board.
 * This class is designed to work well with both Standard and Continuous rotation servos.
 */
@JsModule("johnny-five/lib/servo")
@JsNonModule
open external class Servo : ServoMethods {
    /**
     * @param pin A Number or String address for the Servo pin.
     */
    constructor(pin: Number)
    constructor(option: String)
    constructor(option: ServoGeneralOption)

    open var id: String
    open var pin: dynamic /* Number | String */
    open var range: Array<Number>
    open var invert: Boolean
    open var history: Array<Any>
    open var interval: Number
    open var isMoving: Boolean
    open var last: Any
    open var position: Number
    open var value: Number
    open var startAt: Number

    /**
     * Move a servo horn to specified position in degrees, 0-180 (or whatever the current valid range is). If ms is specified, the servo will take that amount of time to move to the position. If rate is specified, the angle change will be split into distance/rate steps for the ms option.
     * If the specified angle is the same as the current angle, no commands are sent.
     */
    override fun to(degrees: Number, ms: Number? , rate: Number? )
    open fun min()
    open fun max()
    open fun center()
    override fun home()
    override fun sweep(opt: ServoSweepOpts)
    override fun stop()
    override fun cw(speed: Number)
    override fun ccw(speed: Number)
}

external interface ServoMethods{
    /**
     * Move a servo horn to specified position in degrees, 0-180 (or whatever the current valid range is). If ms is specified, the servo will take that amount of time to move to the position. If rate is specified, the angle change will be split into distance/rate steps for the ms option.
     * If the specified angle is the same as the current angle, no commands are sent.
     */
    fun to(degrees: Number, ms: Number? = definedExternally, rate: Number? = definedExternally)

    /**
     * Set Servo to it's startAt position.
     */
    fun home()
    fun sweep(opt: ServoSweepOpts)
    fun stop()
    fun cw(speed: Number)
    fun ccw(speed: Number)
}

external interface ServoSweepOpts {
    var range: Array<Number>
    var interval: Number?
        get() = definedExternally
        set(value) = definedExternally
    var step: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ServoGeneralOption {
    var pin: dynamic /* Number | String */
        get() = definedExternally
        set(value) = definedExternally
    var range: Array<Number>?
        get() = definedExternally
        set(value) = definedExternally
    var type: String?
        get() = definedExternally
        set(value) = definedExternally
    var startAt: Number?
        get() = definedExternally
        set(value) = definedExternally
    var isInverted: Boolean?
        get() = definedExternally
        set(value) = definedExternally

    /**
     * true or false. Optionally center the servo on initialization.
     */
    var center: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var controller: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ServoPCA9685Option : ServoGeneralOption {
    var address: Number?
        get() = definedExternally
        set(value) = definedExternally
}


