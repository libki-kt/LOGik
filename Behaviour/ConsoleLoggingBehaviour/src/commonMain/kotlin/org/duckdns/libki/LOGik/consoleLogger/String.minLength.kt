package org.duckdns.libki.LOGik.consoleLogger

import org.duckdns.libki.LOGik.annotations.StableFeature

@StableFeature
internal fun String.minLength(
    length: Int,
    filler: String
): String {
    var result = this
    while (result.length < length) {
        result = "$filler$result"
    }

    return result
}