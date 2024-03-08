package org.duckdns.libki.LOGik.core

import kotlinx.datetime.Clock
import org.duckdns.libki.LOGik.annotations.AlphaFeature
import org.duckdns.libki.LOGik.annotations.ExperimentalLOGikApi

@AlphaFeature
abstract class Logger<holderType : LoggerHolder>(
    val defaultLogLevel: BasicLogLevelType = BasicLogLevel.Info
) {
    var blockingRulesList: MutableSet<BlockingRule> = mutableSetOf()
    var behaviourList: MutableSet<LoggingBehaviour> = mutableSetOf()
    private var isConfigured: Boolean = false

    abstract fun getHolder(
        forPackage: String,
        component: String
    ) : holderType

    fun log(
        message: LogMessage
    ) {
        val time = Clock.System.now().epochSeconds
        configure()

        val originalLogLevelCheck = blockingRulesList.map {
            it.checkIsAccepted(
                message = message
            )
        }.filter { it }.size == blockingRulesList.size

        val defaultLogLevelCheck = if (message.logLevel.defaultLogLevelRepresentation != null) {
            blockingRulesList.map {
                it.checkIsAccepted(message)
            }.filter { it }.size == blockingRulesList.size
        } else true

        if (
            originalLogLevelCheck
            && defaultLogLevelCheck
        ) {
            behaviourList.forEach {
                it.log(message, time)
            }
        }
    }

    fun log(
        title: String,
        text: String? = null,
        fromComponent: String,
        fromPackage: String,
        errorId: String? = null,
        logLevel: LogLevel = defaultLogLevel,
        additionalData: Any = Unit
    ) {
        log(
            LogMessage(
                title, text, errorId,
                fromComponent, fromPackage,
                logLevel, additionalData
            )
        )
    }

    @OptIn(ExperimentalLOGikApi::class)
    abstract fun setup(scope: LoggerSetupScope)

    @OptIn(ExperimentalLOGikApi::class)
    private fun configure() {
        if (!isConfigured) {
            isConfigured = true
            val scope = LoggerSetupScope()
            setup(scope)
            val result = scope.build()

            behaviourList = result.behaviour.toMutableSet()
            blockingRulesList = result.blockingRules.toMutableSet()
        }
    }
}