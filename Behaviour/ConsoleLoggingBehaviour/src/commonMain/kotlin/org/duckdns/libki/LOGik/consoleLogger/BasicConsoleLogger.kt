package org.duckdns.libki.LOGik.consoleLogger

import org.duckdns.libki.LOGik.annotations.BetaFeature
import org.duckdns.libki.LOGik.annotations.ExperimentalLOGikApi
import org.duckdns.libki.LOGik.core.BlockingRulesConfigurationScope
import org.duckdns.libki.LOGik.core.LogLevel
import org.duckdns.libki.LOGik.core.Logger
import org.duckdns.libki.LOGik.core.LoggerSetupScope

@BetaFeature
class BasicConsoleLogger(
    val blockingRules: BlockingRulesConfigurationScope.() -> Unit = {}
) : Logger(LogLevel.Info) {

    @OptIn(ExperimentalLOGikApi::class)
    override fun setup(scope: LoggerSetupScope) = scope.run {
        production()

        behaviour {
            +ConsoleLoggingBehaviour
        }

        blockingRules {
            blockingRules()
        }
    }

    fun configure(block: BlockingRulesConfigurationScope.() -> Unit) {
        val scope = BlockingRulesConfigurationScope()
        block(scope)
        blockingRulesList = scope.build().toMutableSet()
    }
}