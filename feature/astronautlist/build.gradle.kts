import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.kmp.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.multiplatform)
}

dependencies {
    debugImplementation(libs.jetbrains.compose.ui.tooling)
}

kotlin {
    androidLibrary {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }

        compileSdk = libs.versions.compileSdk.get().toInt()
        minSdk = libs.versions.minSdk.get().toInt()

        namespace = "com.adammcneilly.spacenerd.feature.astronautlist"
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    )

    sourceSets {
        commonMain.dependencies {
            implementation(project(":core:displaymodels"))
            implementation(project(":core:designsystem"))
            implementation(project(":core:models"))
            implementation(project(":core:scaffold"))
            implementation(project(":data:astronauts:api"))
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.compose.material3.adaptive)
            implementation(libs.eygraber.compose.placeholder.material3)
            implementation(libs.jetbrains.compose.material.icons.extended)
            implementation(libs.jetbrains.compose.material3)
            implementation(libs.jetbrains.compose.ui)
            implementation(libs.jetbrains.compose.ui.tooling.preview)
            implementation(libs.koin.compose.viewmodel.navigation)
            implementation(libs.koin.core)
            implementation(libs.kotlinx.datetime)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}
