package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.BetaFeature
import kotlin.reflect.KProperty

@BetaFeature
abstract class LogLevelList<logLevelType : LogLevel>(
    val transform: (
        name: String,
        defaultLogLevelRepresentation: DefaultLogLevel?
    ) -> logLevelType
) {
    val logLevels: MutableSet<logLevelType> = mutableSetOf()

    abstract fun init()

    inner class logLevel(
        val defaultLogLevelRepresentation: DefaultLogLevel? = null
    ) {
        operator fun getValue(
            ref: Any?,
            property: KProperty<*>
        ): logLevelType {
            logLevels.add(
                transform(
                    property.name, defaultLogLevelRepresentation
                )
            )

            return transform(
                property.name, defaultLogLevelRepresentation
            )
        }
    }
}