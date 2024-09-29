package de.jensklingenberg.johnnyfivektwrapper

@JsModule("johnny-five/lib/repl")
@JsNonModule
external interface Repl {
    fun inject(obj: Any)
}