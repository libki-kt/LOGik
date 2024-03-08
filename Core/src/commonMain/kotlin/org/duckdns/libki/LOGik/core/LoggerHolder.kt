package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.NotCompleteFeature

@NotCompleteFeature
open class LoggerHolder(
    private val forPackage: String,
    private val forComponent: String,
    private val log: (LogMessage) -> Unit,
    private val defaultLogLevel: LogLevel
) {
    fun log(
        title: String,
        text: String? = null,
        errorId: String? = null,
        logLevel: LogLevel = defaultLogLevel,
        additionalData: Any = Unit
    ) {
        log(
            LogMessage(
                title = title,
                text = text,
                errorId = errorId,
                logLevel = logLevel,
                fromComponent = forComponent,
                additionalData = additionalData,
                fromPackage = forPackage
            )
        )
    }
}