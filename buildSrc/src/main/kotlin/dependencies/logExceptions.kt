package dependencies

import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

fun KotlinDependencyHandler.logExceptions() = api(project(":LogExceptions"))