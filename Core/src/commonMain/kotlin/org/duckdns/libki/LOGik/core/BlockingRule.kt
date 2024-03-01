package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.BetaFeature

@BetaFeature
abstract class BlockingRule {
    abstract fun checkIsAccepted(message: LogMessage): Boolean
}