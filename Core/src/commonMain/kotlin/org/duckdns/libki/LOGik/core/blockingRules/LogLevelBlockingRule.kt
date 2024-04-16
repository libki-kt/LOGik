package org.duckdns.libki.LOGik.core.blockingRules

import org.duckdns.libki.LOGik.annotations.BetaFeature
import org.duckdns.libki.LOGik.core.BlockingRule
import org.duckdns.libki.LOGik.core.LogLevel
import org.duckdns.libki.LOGik.core.LogMessage

@BetaFeature
class LogLevelBlockingRule(
    private val forLevel: LogLevel
) : BlockingRule() {
    override fun checkIsAccepted(message: LogMessage): Boolean {
        return message.logLevel !=  forLevel
    }
}