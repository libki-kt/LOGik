package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.BetaFeature

@BetaFeature
class DefaultLogLevelBlockingRule(
    private val forLevel: DefaultLogLevel
) : BlockingRule() {
    override fun checkIsAccepted(message: LogMessage): Boolean {
        return message.logLevel.defaultLogLevelRepresentation != forLevel
    }
}