package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.StableFeature

@StableFeature
abstract class LogLevel(
    val name: String,
    val defaultLogLevelRepresentation: DefaultLogLevel?
)