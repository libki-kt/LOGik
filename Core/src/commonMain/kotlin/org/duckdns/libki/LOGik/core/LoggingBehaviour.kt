package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.BetaFeature

@BetaFeature
abstract class LoggingBehaviour {
    abstract fun log(
        message: LogMessage,
        timestamp: Long
    )
}