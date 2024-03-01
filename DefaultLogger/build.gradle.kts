import dependencies.annotations
import dependencies.consoleLoggingBehaviour
import dependencies.core

plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    js()
    linuxX64()
    mingwX64()

    sourceSets {
        commonMain.dependencies {
            core()
            consoleLoggingBehaviour()
            annotations()
        }
    }
}