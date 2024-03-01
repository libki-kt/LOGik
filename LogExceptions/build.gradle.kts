import dependencies.annotations
import dependencies.core

plugins {
    kotlin("multiplatform")
}

kotlin {
    AllTargets()

    sourceSets {
        commonMain {
            dependencies {
                annotations()
                core()
            }
        }
    }
}