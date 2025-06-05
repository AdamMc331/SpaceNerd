plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.room)
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
            implementation(project(":core:models"))
            implementation(project(":data:launch:api"))
            implementation(libs.androidx.room.runtime)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}
