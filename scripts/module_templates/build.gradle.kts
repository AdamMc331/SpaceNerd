import org.jmailen.gradle.kotlinter.tasks.FormatTask
import org.jmailen.gradle.kotlinter.tasks.LintTask

plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    )

    sourceSets {
        commonMain.dependencies {

        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}

tasks.withType<FormatTask> {
    exclude { it.file.path.contains("build/") }
}

tasks.withType<LintTask> {
    exclude { it.file.path.contains("build/") }
}
