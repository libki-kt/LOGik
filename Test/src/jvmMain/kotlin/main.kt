import org.duckdns.libki.LOGik.core.LogLevel
import org.duckdns.libki.LOGik.defaultLogger.defaultLogger
import org.duckdns.libki.LOGik.logExceptions.log

suspend fun main() {
    defaultLogger.awaitLaunch()

    defaultLogger.log(
        title = "Hello!",
        text = "hello",
        fromComponent = "test",
        fromPackage = "libki.test",
        errorId = "information/1",
        logLevel = LogLevel.Debug
    )

    defaultLogger.log(
        title = "Hello!",
        text = "hello",
        fromComponent = "test",
        fromPackage = "libki.test",
        errorId = "information/1"
    )

    defaultLogger.log(
        title = "Hello!",
        text = "hello",
        fromComponent = "test",
        fromPackage = "libki.test",
        errorId = "information/1",
        logLevel = LogLevel.Warning
    )

    defaultLogger.log(
        title = "Hello!",
        text = "hello",
        fromComponent = "test",
        fromPackage = "libki.test",
        errorId = "information/1",
        logLevel = LogLevel.Error
    )

    defaultLogger.log(
        title = "Hello!",
        text = "hello",
        fromComponent = "test",
        fromPackage = "libki.test",
        errorId = "information/1",
        logLevel = LogLevel.Critical
    )

    defaultLogger.log(
        title = "hello",
        text = "example",
        fromComponent = "test",
        fromPackage = "example"
    )

    try {
        2/0
    } catch (e: Exception) {
        defaultLogger.log(
            exception = e,
            fromComponent = "test",
            fromPackage = "libki.test",
            errorId = "testError/1"
        )
    }
}