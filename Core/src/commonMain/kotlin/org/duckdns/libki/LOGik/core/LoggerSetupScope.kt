package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.NotCompleteFeature

@NotCompleteFeature
class LoggerSetupScope {
    private val blockingRules: MutableList<BlockingRule> = mutableListOf()
    private val behaviour: MutableList<LoggingBehaviour> = mutableListOf()

    fun blockingRules(body: BlockingRulesConfigurationScope.() -> Unit) {
        val scope = BlockingRulesConfigurationScope()
        body(scope)
        blockingRules.addAll(scope.build())
    }

    fun behaviour(body: BehaviourConfigurationScope.() -> Unit) {
        val scope = BehaviourConfigurationScope()
        body(scope)
        behaviour.addAll(scope.build())
    }

    fun build(): LoggerConfiguration = LoggerConfiguration(
        blockingRules = blockingRules,
        behaviour = behaviour
    )

    operator fun invoke(body: LoggerSetupScope.() -> Unit) {
        body(this)
    }
}