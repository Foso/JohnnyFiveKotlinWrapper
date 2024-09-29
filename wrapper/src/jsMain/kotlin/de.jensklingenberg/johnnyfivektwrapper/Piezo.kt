package de.jensklingenberg.johnnyfivektwrapper

import de.jensklingenberg.johnnyfivektwrapper.utils.objectOf

@JsModule("johnny-five/lib/piezo")
@JsNonModule
open external class Piezo {
    constructor(option: Number)
    constructor(option: PiezoOption)

    open var id: String
    open var pin: Number
    open var mode: Number
    open var isPlaying: Boolean
    open fun frequency(frequency: Number, duration: Number)

    /**
     *  Play a tune with an optional callback to invoke when the tune is done playing.
     *  The tune object contains a song (an array of the notes in the tune) and optional settings (e.g. tempo):
     */
    open fun play(tune: dynamic, cb: () -> Unit = definedExternally)
    open fun tone(frequency: Number, duration: Number)
    open fun noTone()
    open fun off()

}

fun Piezo.play(tune: PiezoTune, cb: () -> Unit) {
    this.play(tune, cb)
}

fun PiezoTune(songs: Array<PiezoSong>, tempo: Number = 100): PiezoTune {
    return objectOf {
        song = songs.map { arrayOf(it.note, it.duration) }.toTypedArray()
        this.tempo = tempo
    }
}

external interface PiezoTune {
    var song: Array<Array<dynamic>>
    var tempo: Number
}

class PiezoSong(var note: String?, var duration: Number)

external interface PiezoOption {
    var pin: Number
}