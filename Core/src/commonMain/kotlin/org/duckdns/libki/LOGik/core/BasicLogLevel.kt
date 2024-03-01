package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.BetaFeature

@BetaFeature
object BasicLogLevel : LogLevelList<BasicLogLevelType>(
    transform = { name, defaultLogLevelRepresentation -> BasicLogLevelType(name, defaultLogLevelRepresentation) }
) {
    override fun init() {
        Info; Warning; Error; Critical
    }

    val Info by logLevel(DefaultLogLevel.Info)

    val Warning by logLevel(DefaultLogLevel.Warning)

    val Error by logLevel(DefaultLogLevel.Error)

    val Critical by logLevel(DefaultLogLevel.Critical)
}