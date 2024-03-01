package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.BetaFeature

@BetaFeature
object BasicLogLevels : LogLevels<BasicLogLevelType>() {
    override val default: BasicLogLevelType = BasicLogLevel.Error
    override val logLevels: List<BasicLogLevelType> = listOf()
}