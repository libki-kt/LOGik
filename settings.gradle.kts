//utils
include(":Annotations")

//components
//      main
include(":Core")
//      behaviours
include(":Behaviour:ConsoleLoggingBehaviour")
//other
include(":LogExceptions")
include(":DefaultLogger")
include("LoggerableGenerator")

//test
include(":Test")

rootProject.name = "LOGik"

pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    val kotlinVersion = extra["kotlin.version"]

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.multiplatform" -> useModule(
                    "org.jetbrains.kotlin.multiplatform:org.jetbrains.kotlin.multiplatform.gradle.plugin:$kotlinVersion"
                )

                "org.jetbrains.kotlin.jvm" -> useModule(
                    "org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin:$kotlinVersion"
                )

                /*"org.jetbrains.kotlin.plugin.serialization" -> useModule(
                    "org.jetbrains.kotlin.plugin.serialization:org.jetbrains.kotlin.plugin.serialization.gradle.plugin:$kotlinVersion"
                )*/
            }
        }
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "latest.release"
    kotlin("multiplatform") version "1.9.22" apply false
    kotlin("jvm") version "1.9.22" apply false
}
