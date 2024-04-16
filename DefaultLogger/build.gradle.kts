import dependencies.annotations
import dependencies.consoleLoggingBehaviour
import dependencies.core

plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm {
        jvmToolchain(20)
    }
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