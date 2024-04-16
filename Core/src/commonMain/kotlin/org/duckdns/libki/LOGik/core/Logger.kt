package org.duckdns.libki.LOGik.core

import kotlinx.coroutines.*
import kotlinx.datetime.Clock
import org.duckdns.libki.LOGik.annotations.AlphaFeature
import org.duckdns.libki.LOGik.annotations.ExperimentalLOGikApi
import kotlin.coroutines.suspendCoroutine
import kotlin.time.Duration.Companion.seconds

@AlphaFeature
abstract class Logger(
    val defaultLogLevel: LogLevel = LogLevel.Info
) {
    var blockingRulesList: MutableSet<BlockingRule> = mutableSetOf()
    var behaviourList: MutableSet<LoggingBehaviour> = mutableSetOf()
    var isEnabled: Boolean = true
    private var isConfigured: Boolean = false

    suspend fun log(
        title: String,
        text: String? = null,
        fromComponent: String,
        fromPackage: String,
        errorId: String? = null,
        logLevel: LogLevel = defaultLogLevel
    ) = coroutineScope {
        if (!isEnabled) return@coroutineScope

        val logMessage = LogMessage(
            title = title,
            text = text,
            errorId = errorId,
            fromComponent = fromComponent,
            fromPackage = fromPackage,
            logLevel = logLevel
        )

        val isBlocked = blockingRulesList
            .map { it.checkIsAccepted(logMessage) }
            .size != blockingRulesList.size

        if (isBlocked) return@coroutineScope

        val currentTime = Clock.System.now().epochSeconds

        behaviourList.forEach { behaviour ->
            launch {
                behaviour.log(logMessage, currentTime)
            }
        }
    }

    @OptIn(ExperimentalLOGikApi::class)
    abstract fun setup(scope: LoggerSetupScope)

    init {
        CoroutineScope(Dispatchers.Default).launch {
            launch { delay(1.seconds); conf() }
        }
    }

    suspend fun awaitLaunch() {
        delay(2.seconds)
    }

    @OptIn(ExperimentalLOGikApi::class)
    private fun conf() {
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