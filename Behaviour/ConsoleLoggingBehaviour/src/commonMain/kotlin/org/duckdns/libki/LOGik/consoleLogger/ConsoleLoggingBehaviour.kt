package org.duckdns.libki.LOGik.consoleLogger

import com.github.ajalt.colormath.Color
import com.github.ajalt.colormath.parse
import com.github.ajalt.mordant.rendering.TextColors
import com.github.ajalt.mordant.rendering.TextStyle
import kotlinx.datetime.*
import org.duckdns.libki.LOGik.annotations.BetaFeature
import org.duckdns.libki.LOGik.core.DefaultLogLevel
import org.duckdns.libki.LOGik.core.LogLevel
import org.duckdns.libki.LOGik.core.LogMessage
import org.duckdns.libki.LOGik.core.LoggingBehaviour

@BetaFeature
object ConsoleLoggingBehaviour : LoggingBehaviour() {
    override fun log(message: LogMessage, timestamp: Long) {
        //package -> component -> error id -> message

        val logLevelString = when (message.logLevel) {
            LogLevel.Info -> "${(TextColors.brightWhite on TextColors.blue)(" ${message.logLevel.name} ")}${
                (TextColors.blue on TextColors.gray(.2f))(
                    "\uE0B0"
                )
            }"

            LogLevel.Error -> "${(TextColors.brightWhite on TextColors.rgb("#F28C28"))(" ${message.logLevel.name} ")}${
                (TextColors.rgb("#F28C28") on TextColors.gray(.2f))(
                    "\uE0B0"
                )
            }"

            LogLevel.Warning -> "${(TextColors.brightWhite on TextColors.yellow)(" ${message.logLevel.name} ")}${
                (TextColors.yellow on TextColors.gray(.2f))(
                    "\uE0B0"
                )
            }"

            LogLevel.Critical -> "${
                (TextColors.brightWhite on TextColors.red)(
                    " Critical "
                )
            }${(TextColors.red on TextColors.gray(.2f))("\uE0B0")}"

            LogLevel.Debug -> "${
                (TextColors.brightWhite on TextColors.red)(
                    " Critical "
                )
            }${(TextColors.red on TextColors.gray(.2f))("\uE0B0")}"
        }

        val textColorFunction: (String) -> String = when (message.logLevel) {
            LogLevel.Info -> ({
                TextStyle(
                    color = TextColors.blue
                )(it)
            })

            LogLevel.Warning -> ({
                TextStyle(
                    underline = true,
                    color = TextColors.yellow,
                    bold = true
                )(it)
            })

            LogLevel.Error -> ({
                TextStyle(
                    underline = true,
                    color = Color.parse("#F28C28"),
                    bold = true
                )(it)
            })

            LogLevel.Critical -> ({
                TextStyle(
                    color = TextColors.brightRed,
                    bold = true,
                    italic = true,
                    underline = true,
                    bgColor = TextColors.black
                )(it)
            })

            LogLevel.Debug -> ({
                TextStyle(
                    color = TextColors.brightRed,
                    bold = true,
                    italic = true,
                    underline = true,
                    bgColor = TextColors.black
                )(it)
            })
        }

        val time = Instant.fromEpochSeconds(timestamp).toLocalDateTime(TimeZone.currentSystemDefault())
        val timeAsString = "${time.dayOfMonth.toString().minLength(2, "0")}." +
                "${time.monthNumber.toString().minLength(2, "0")}." +
                "${time.year.toString().minLength(2, "0")} - " +
                "${time.hour.toString().minLength(2, "0")}:" +
                "${time.minute.toString().minLength(2, "0")}:" +
                time.second.toString().minLength(2, "0")

        println(
            "${TextColors.green("\uE0B2")}${(TextColors.brightWhite on TextColors.green)(" $timeAsString ")}${
                (TextColors.green on
                        when (message.logLevel) {
                            LogLevel.Error -> TextColors.rgb("#F28C28")
                            LogLevel.Warning -> TextColors.yellow
                            LogLevel.Critical -> TextColors.brightRed
                            LogLevel.Info -> TextColors.blue
                            LogLevel.Debug -> TextColors.blue
                        })("\uE0B0")
            }" + logLevelString + "${
                (TextColors.brightWhite on TextColors.gray(.2f))(
                    " ${message.fromPackage} "
                )
            }${(TextColors.gray(.2f) on TextColors.gray)("\uE0B0")}" +
                    "${
                        (TextColors.brightWhite on TextColors.gray)(
                            " ${message.fromComponent} "
                        )
                    }${if (message.errorId != null) (TextColors.gray on TextColors.gray(.4f))("\uE0B0") else ""}" +
                    "${
                        if (message.errorId != null) (TextColors.brightWhite on TextColors.gray(.4f))(
                            " ${message.errorId} "
                        ) else ""
                    }${((if (message.errorId != null) TextColors.gray(.4f) else TextColors.gray) on TextColors.magenta)("\uE0B0")}"
                    + "${
                (TextColors.brightWhite on TextColors.magenta)(
                    " ${message.title} "
                )
            }${TextColors.magenta("\uE0B0")}"
                    + (if (message.text != null) "\n" + (message.text?: "").split('\n')
                .dropLastWhile { it.isBlank() }
                .joinToString(
                    separator = "\n"
                ) {
                    val whiteSpaceCount = it.takeWhile { char -> char == ' ' || char == '\t' }.length
                    val whiteSpaces = it.substring(0..<whiteSpaceCount)
                    val normalCharacters = it.removePrefix(whiteSpaces)

                    "\t" + whiteSpaces + textColorFunction(normalCharacters)
                } else "") + "\n"
        )
    }
}