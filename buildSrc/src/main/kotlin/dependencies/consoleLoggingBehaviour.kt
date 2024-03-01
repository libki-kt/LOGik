package dependencies

import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

fun KotlinDependencyHandler.consoleLoggingBehaviour() = implementation(project(":Behaviour:ConsoleLoggingBehaviour"))