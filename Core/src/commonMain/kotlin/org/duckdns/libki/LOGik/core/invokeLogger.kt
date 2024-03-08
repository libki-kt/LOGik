package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.AlphaFeature

@AlphaFeature
operator fun <L : Logger<H>, H : LoggerHolder, R> L.invoke(
    block: L.() -> R
): R = block()