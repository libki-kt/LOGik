package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.AlphaFeature

@AlphaFeature
class BehaviourConfigurationScope {
    private val behaviourList: MutableList<LoggingBehaviour> = mutableListOf()

    operator fun LoggingBehaviour.unaryPlus() {
        behaviourList.add(this)
    }

    fun build(): List<LoggingBehaviour> {
        return behaviourList
    }
}