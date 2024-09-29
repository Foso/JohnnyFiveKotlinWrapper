package de.jensklingenberg.johnnyfivektwrapper


open external class Collection<Base> {
    constructor(options: Array<Any? /* Number? | String? | Any? */>)
    constructor(options: CollectionPinOptions)

    open var type: Base?
    open fun add(vararg args: Any? /* Number? | Any? */): Number
    open fun each(callback: (item: Base, index: Number) -> Unit): Collection<Base> /* this */
    open fun forEach(callback: (item: Base, index: Number) -> Unit): Collection<Base> /* this */
    open fun includes(item: Base): Boolean
    open fun indexOf(item: Base): Number
    open fun map(callback: (item: Base, index: Number) -> Unit): Array<Any>
    open fun slice(begin: Number = definedExternally, end: Number = definedExternally): Collection<Base>
    open fun byId(id: Any): Base?

    companion object {
        fun installMethodForwarding(target: Any?, source: Any?): Any?
    }
}

external interface CollectionPinOptions {
    var pins: Array<dynamic /* String | Number */>

    @nativeGetter
    operator fun get(key: String): Any?

    @nativeSetter
    operator fun set(key: String, value: Any)
}
