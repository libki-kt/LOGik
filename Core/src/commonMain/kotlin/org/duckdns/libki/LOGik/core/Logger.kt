package org.duckdns.libki.LOGik.core

import kotlinx.datetime.Clock
import org.duckdns.libki.LOGik.annotations.AlphaFeature

@AlphaFeature
abstract class Logger(
    val defaultLogLevel: BasicLogLevelType = BasicLogLevel.Info
) {
    var blockingRulesList: MutableSet<BlockingRule> = mutableSetOf()
    var behaviourList: MutableSet<LoggingBehaviour> = mutableSetOf()
    private var isConfigured: Boolean = false

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
        errorId: ErrorId,
        logLevel: LogLevel = defaultLogLevel
    ) {
        log(
            LogMessage(
                title, text, fromComponent,
                errorId, logLevel
            )
        )
    }

    abstract fun setup(scope: LoggerSetupScope)

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