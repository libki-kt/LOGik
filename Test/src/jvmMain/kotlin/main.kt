import org.duckdns.libki.LOGik.core.BasicLogLevel
import org.duckdns.libki.LOGik.core.ErrorId
import org.duckdns.libki.LOGik.defaultLogger.defaultLogger
import org.duckdns.libki.LOGik.logExceptions.log

fun main() {
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
        logLevel = BasicLogLevel.Warning
    )

    defaultLogger.log(
        title = "Hello!",
        text = "hello",
        fromComponent = "test",
        fromPackage = "libki.test",
        errorId = "information/1",
        logLevel = BasicLogLevel.Error
    )

    defaultLogger.log(
        title = "Hello!",
        text = "hello",
        fromComponent = "test",
        fromPackage = "libki.test",
        errorId = "information/1",
        logLevel = BasicLogLevel.Critical
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