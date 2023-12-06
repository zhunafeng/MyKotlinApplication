package com.example.mykotlinapplication.base

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

    /**
     * Generic object delegate
     */
    class ObjectDelegate<V> : ReadWriteProperty<Any?, V> {

        private var value: V? = null

        override fun getValue(thisRef: Any?, property: KProperty<*>): V =
            value ?: throw IllegalStateException("${javaClass.name} should not be accessed before attach or after detach")

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: V) {
            this.value = value
        }

        fun attach(value: V) {
            this.value = value
        }

        fun detach() {
            this.value = null
        }

        fun isAttached(): Boolean {
            return this.value != null
        }
    }
