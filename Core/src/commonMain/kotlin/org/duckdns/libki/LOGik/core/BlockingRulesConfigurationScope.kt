package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.AlphaFeature

@AlphaFeature
class BlockingRulesConfigurationScope {
    private val blockingRulesList: MutableList<BlockingRule> = mutableListOf()

    fun disallow(logLevel: LogLevel) {
        blockingRulesList.add(LogLevelBlockingRule(logLevel))
    }

    fun disallow(logLevel: DefaultLogLevel) {
        blockingRulesList.add(DefaultLogLevelBlockingRule(logLevel))
    }

    fun build(): List<BlockingRule> = blockingRulesList.toList()
}