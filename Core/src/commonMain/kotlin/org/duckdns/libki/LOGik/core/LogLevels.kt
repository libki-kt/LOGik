package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.BetaFeature

@BetaFeature
abstract class LogLevels<logLevelType : LogLevel> {
    abstract val default: logLevelType

    abstract val logLevels: List<logLevelType>
}