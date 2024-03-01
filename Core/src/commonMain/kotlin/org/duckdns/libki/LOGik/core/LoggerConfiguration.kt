package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.BetaFeature

@BetaFeature
class LoggerConfiguration(
    val blockingRules: MutableList<BlockingRule> = mutableListOf(),
    val behaviour: MutableList<LoggingBehaviour> = mutableListOf()
)