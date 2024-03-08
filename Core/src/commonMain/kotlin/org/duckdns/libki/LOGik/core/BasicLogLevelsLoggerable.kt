package org.duckdns.libki.LOGik.core

import org.duckdns.libki.LOGik.annotations.NotCompleteFeature

@NotCompleteFeature
interface BasicLogLevelsLoggerable {
    fun <H : LoggerHolder> Logger<H>.info() {

    }
}