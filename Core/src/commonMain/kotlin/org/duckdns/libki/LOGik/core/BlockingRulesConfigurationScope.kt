package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.AlphaFeature
import org.duckdns.libki.LOGik.core.blockingRules.LogLevelBlockingRule

@AlphaFeature
class BlockingRulesConfigurationScope {
    private val blockingRulesList: MutableList<BlockingRule> = mutableListOf()

    fun disallow(logLevel: LogLevel) {
        blockingRulesList.add(LogLevelBlockingRule(logLevel))
    }

    fun build(): List<BlockingRule> = blockingRulesList.toList()
}