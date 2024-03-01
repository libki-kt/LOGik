package dependencies

import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

fun KotlinDependencyHandler.annotations() = this.apply {
    api(project(":Annotations"))
}