import dependencies.annotations

plugins {
    kotlin("multiplatform")
}

kotlin {
    AllTargets()

    sourceSets {
        commonMain {
            dependencies {
                annotations()
                api("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0-RC")
            }
        }
    }
}