package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.BetaFeature

@BetaFeature
class LogLevelBlockingRule(
    private val forLevel: LogLevel
) : BlockingRule() {
    override fun checkIsAccepted(message: LogMessage): Boolean {
        return message.logLevel !=  forLevel
    }
}