package de.jensklingenberg.johnnyfivektwrapper

class Servos(private val servos: List<Servo>) {
    fun to(degrees: Number, ms: Number? = null, rate: Number? = null) {
        servos.forEach {
            it.to(degrees, ms, rate)
        }
    }

    fun home() {
        servos.forEach {
            it.home()
        }
    }

    fun sweep(opt: ServoSweepOpts) {
        servos.forEach {
            it.sweep(opt)
        }
    }

    fun stop() {
        servos.forEach {
            it.stop()
        }
    }

    fun cw(speed: Number) {
        servos.forEach {
            it.cw(speed)
        }
    }

    fun ccw(speed: Number) {
        servos.forEach {
            it.ccw(speed)
        }
    }

    fun min() {
        servos.forEach {
            it.min()
        }
    }


}