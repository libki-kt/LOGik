package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.StableFeature

@StableFeature
open class LogMessage(
    val title: String,
    val text: String? = null,
    val fromComponent: String,
    val errorId: ErrorId,
    val logLevel: LogLevel
)
