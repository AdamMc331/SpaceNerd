import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kmp.library)
    alias(libs.plugins.cash.paparazzi)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.compose)
}

kotlin {
    android {
        namespace = "com.adammcneilly.spacenerd.test.paparazzi"
        compileSdk = libs.versions.compileSdk.get().toInt()
        minSdk = libs.versions.minSdk.get().toInt()

        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }

        withHostTest {}
    }

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
            implementation(project(":core:datetime"))
            implementation(project(":core:designsystem"))
            implementation(project(":core:displaymodels"))
            implementation(project(":core:models"))
            implementation(project(":core:models-test"))
            implementation(project(":core:scaffold"))
            implementation(project(":feature:astronautlist"))
            implementation(project(":feature:launchlist"))
            implementation(project(":feature:launchdetail"))
            implementation(project(":feature:news"))
            implementation(project(":feature:stationdetail"))
            implementation(project(":feature:stationlist"))
            implementation(libs.compose.material3.adaptive)
            implementation(libs.google.testparameterinjector)
            implementation(libs.jetbrains.compose.material3)
            implementation(libs.jetbrains.compose.ui)
            implementation(libs.kotlinx.datetime)
        }

        named("androidHostTest") {
            dependencies {
                implementation(project.dependencies.platform(libs.compose.bom))
                implementation(kotlin("test"))
                implementation(project(":core:datetime"))
                implementation(project(":core:designsystem"))
                implementation(project(":core:displaymodels"))
                implementation(project(":core:models"))
                implementation(project(":core:models-test"))
                implementation(project(":core:scaffold"))
                implementation(project(":feature:launchlist"))
                implementation(project(":feature:launchdetail"))
                implementation(project(":feature:news"))
                implementation(project(":feature:stationdetail"))
                implementation(project(":feature:stationlist"))
                implementation(libs.compose.material)
                implementation(libs.compose.ui)
                implementation(libs.google.testparameterinjector)
                implementation(libs.kotlinx.datetime)
            }
        }
    }
}
