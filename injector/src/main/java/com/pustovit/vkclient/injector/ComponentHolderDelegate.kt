package com.pustovit.vkclient.injector

import java.lang.ref.WeakReference
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 12:30
 */
class ComponentHolderDelegate<D : FeatureDependencies, C>(
    private val componentFactory: (D) -> C
) : ReadOnlyProperty<ComponentHolder<*, D>, C> {

    // Weak reference to the component
    private var componentWeakRef: WeakReference<C>? = null
    override fun getValue(thisRef: ComponentHolder<*, D>, property: KProperty<*>): C {
        return getComponent(thisRef)
    }

    private fun getComponent(thisRef: ComponentHolder<*, D>): C {
        var component: C? = null
        synchronized(this) {
            thisRef.dependencyProvider?.let { dependencyProvider ->
                component = componentWeakRef?.get()
                if (component == null) {
                    val featureDependencies = dependencyProvider.invoke()
                    component = componentFactory.invoke(featureDependencies)
                    componentWeakRef = WeakReference(component)
                    println(
                        "componentTag " +
                                "${thisRef::class.java} new component=${componentWeakRef.hashCode()}"
                    )
                } else {
                    println(
                        "componentTag " +
                                "${thisRef::class.java} old component=${componentWeakRef.hashCode()}"
                    )
                }
            } ?: throw IllegalStateException("${thisRef}, dependencyProvider is not initialized")

            return component
                ?: throw IllegalStateException("${thisRef}, component is not initialized")
        }
    }
}