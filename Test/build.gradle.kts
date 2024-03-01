import dependencies.consoleLoggingBehaviour
import dependencies.core
import dependencies.defaultLogger
import dependencies.logExceptions
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        mainRun {
            mainClass = "MainKt"
        }
    }

    sourceSets {
        jvmMain.dependencies {
            consoleLoggingBehaviour()
            defaultLogger()
            logExceptions()
            core()
        }
    }
}