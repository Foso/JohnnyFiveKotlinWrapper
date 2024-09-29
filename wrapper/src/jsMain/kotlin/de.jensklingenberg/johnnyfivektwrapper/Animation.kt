package de.jensklingenberg.johnnyfivektwrapper

/**
 * @property target Overrides the target passed when the Animation was created
 * @property duration Duration of the segment in milliseconds (default 1000)
 * @property cuePoints Array of values from 0.0 to 1.0 representing the beginning and end of the animation respectively (default [0, 1])
 * @property keyFrames A 1 or 2 dimensional array of device positions over time. See more on keyFrames below. (required)
 * @property easing An easing function from ease-component to apply to the playback head on the timeline. See the ease-component docs for a list of available easing functions (default: "linear")
 * @property loop When true, segment will loop until animation.next() or animation.stop() is called (default: false)
 * @property loopback The cuePoint that the animation will loop back to. If the animation is playing in reverse, this is the point at which the animation will "loop back" to 1.0 (default: 0.0)
 * @property metronomic Will play to cuePoint[1] then play in reverse to cuePoint[0]. If the segment is set to loop then the animation will play back and forth until next(), pause() or stop() are called (default: false)
 * @property progress The starting point for the playback head (default 0.0)
 * @property currentSpeed Controls the speed of the playback head and scales the calculated duration of this and all subsequent segments until it is changed by another segment or a call to the speed() method (default: 1.0)
 * @property fps The maximum frames per second for the segment (default: 60)
 * @property onstart Function to execute when segment is started (default: none)
 * @property onpause Function to execute when segment is paused (default: none)
 * @property onstop Function to execute when animation is stopped (default: none)
 * @property oncomplete Function to execute when segment is completed (default: none)
 * @property onloop Function to execute when segment loops (default: none)
 */
@JsModule("johnny-five/lib/animation")
@JsNonModule
open external class Animation {
    constructor(option: Servo)
    constructor(option: Array<Servo>)

    open var target: Number
    open var duration: Number
    open var cuePoints: Array<Number>
    open var keyFrames: Number
    open var easing: String
    open var loop: Boolean
    open var loopback: Number
    open var metronomic: Boolean
    open var progress: Number
    open var currentSpeed: Number
    open var fps: Number
    open fun enqueue(segment: Any)
    open fun play()
    open fun pause()
    open fun stop()
    open fun next()
    open fun speed(speed: Array<Number>)
}