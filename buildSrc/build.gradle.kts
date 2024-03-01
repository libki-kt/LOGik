plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin-api:1.9.22")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-properties:1.6.3")

    //later this would be migrated to yoIO
    implementation("com.soywiz.korge:korge-core:5.3.1")
}