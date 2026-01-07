import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.mokkery)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    )

    sourceSets {
        commonMain.dependencies {
            implementation(project(":core:datetime"))
            implementation(project(":core:displaymodels"))
            implementation(project(":core:designsystem"))
            implementation(project(":core:models"))
            implementation(project(":core:scaffold"))
            implementation(project(":data:article:api"))
            implementation(compose.material3)
            implementation(compose.materialIconsExtended)
            implementation(compose.ui)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.compose.material3.adaptive)
            implementation(libs.eygraber.compose.placeholder.material3)
            implementation(libs.koin.compose.viewmodel.navigation)
            implementation(libs.koin.core)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation(project(":core:models-test"))
            implementation(libs.cash.turbine)
            implementation(libs.kotlinx.coroutines.test)
            implementation(libs.varabyte.truthish)
        }
    }
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    namespace = "com.adammcneilly.spacenerd.feature.news"
}
