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
            implementation(libs.kotlinx.datetime)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}

tasks.formatKotlinCommonMain {
    exclude { it.file.path.contains("build/") }
}

tasks.lintKotlinCommonMain {
    exclude { it.file.path.contains("build/") }
}
