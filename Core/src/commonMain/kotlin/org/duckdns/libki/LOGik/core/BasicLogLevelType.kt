package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.BetaFeature

@BetaFeature
class BasicLogLevelType(
    name: String,
    defaultLogLevelRepresentation: DefaultLogLevel?
) : LogLevel(name, defaultLogLevelRepresentation)