package org.duckdns.libki.LOGik.logExceptions

import org.duckdns.libki.LOGik.annotations.StableFeature
import org.duckdns.libki.LOGik.core.BasicLogLevel
import org.duckdns.libki.LOGik.core.ErrorId
import org.duckdns.libki.LOGik.core.LogLevel
import org.duckdns.libki.LOGik.core.Logger

@StableFeature
fun Logger<*>.log(
    exception: Exception,
    fromComponent: String,
    fromPackage: String,
    errorId: String? = null,
    logLevel: LogLevel = BasicLogLevel.Critical,
    additionalData: Any = Unit
) {
    val messages: MutableList<Throwable> = mutableListOf()

    log(
        title = exception::class.simpleName ?: "Unknown error",
        text = exception.stackTraceToString() + "\n\n"
                + messages.joinToString(
            separator = "\n\n"
        ) { it.message.toString() },
        fromComponent = fromComponent,
        errorId = errorId,
        fromPackage = fromPackage,
        logLevel = logLevel,
        additionalData = additionalData
    )
}