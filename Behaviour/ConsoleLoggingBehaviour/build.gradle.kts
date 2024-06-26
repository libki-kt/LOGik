import dependencies.annotations
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
            api("com.github.ajalt.mordant:mordant:2.3.0")
            annotations()
            core()
        }
    }
}