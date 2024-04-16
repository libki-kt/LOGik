package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.ExperimentalLOGikApi

@ExperimentalLOGikApi
class LoggerSetupScope {
    private val blockingRules: MutableList<BlockingRule> = mutableListOf()
    private val behaviour: MutableList<LoggingBehaviour> = mutableListOf()
    private var shipmentLevel: ShipmentLevel = ShipmentLevel.Production
    private var enabled: Boolean = true

    fun disable() { enabled = false }
    fun enable() { enabled = true }

    fun production() { shipmentLevel = ShipmentLevel.Production }
    fun inDevelopment() { shipmentLevel = ShipmentLevel.InDevelopment }

    fun whenInProduction(
        block: () -> Unit
    ) {
        if (shipmentLevel == ShipmentLevel.Production) {
            block()
        }
    }

    fun whenInDevelopment(
        block: () -> Unit
    ) {
        if (shipmentLevel == ShipmentLevel.InDevelopment) {
            block()
        }
    }

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
    behaviour = behaviour,
    isEnabled = enabled
    )

    operator fun invoke(body: LoggerSetupScope.() -> Unit) {
        body(this)
    }
}