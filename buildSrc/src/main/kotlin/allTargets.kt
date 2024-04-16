import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

fun KotlinMultiplatformExtension.AllTargets() {
    this.jvm {
        jvmToolchain(20)
    }

    this.js {
        browser()
        nodejs()
    }

    this.linuxX64()
    this.linuxArm64()
    this.mingwX64()
}