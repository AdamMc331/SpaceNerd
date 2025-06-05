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
            implementation(project(":data:cache:api"))
            implementation(libs.androidx.room.runtime)
            implementation(libs.kotlinx.datetime)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}
