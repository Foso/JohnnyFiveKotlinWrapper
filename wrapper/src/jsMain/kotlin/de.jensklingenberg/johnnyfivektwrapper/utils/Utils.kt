package de.jensklingenberg.johnnyfivektwrapper.utils


inline fun <I> objectOf(
    jsonObject: I = js("new Object()").unsafeCast<I>(),
    writer: I.() -> Unit
): I {
    writer(jsonObject)
    return jsonObject
}

inline fun jsObject(init: dynamic.() -> Unit): dynamic {
    val o = js("{}")
    init(o)
    return o
}