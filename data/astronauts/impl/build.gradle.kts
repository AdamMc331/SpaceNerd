import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.kmp.library)
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    androidLibrary {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }

        compileSdk = libs.versions.compileSdk.get().toInt()
        minSdk = libs.versions.minSdk.get().toInt()

        namespace = "com.adammcneilly.spacenerd.data.astronauts.impl"
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    )

    sourceSets {
        commonMain.dependencies {
            implementation(project(":core:datetime"))
            implementation(project(":core:models"))
            implementation(project(":data:astronauts:api"))
            implementation(project(":data:cache"))
            implementation(project(":data:local:room"))
            implementation(project(":data:remote:ktor"))
            implementation(project(":data:remote:tsd"))
            implementation(libs.kotlinx.coroutines.core)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation(project(":core:datetime"))
            implementation(project(":core:models-test"))
            implementation(project(":data:remote:ktor-test"))
            implementation(project(":data:remote:tsd-test"))
            implementation(libs.cash.turbine)
            implementation(libs.kotlinx.coroutines.test)
            implementation(libs.varabyte.truthish)
        }
    }
}
