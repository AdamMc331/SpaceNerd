import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.multiplatform)
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
            implementation(project(":core:models"))
            implementation(project(":data:cache"))
            implementation(project(":data:article:api"))
            implementation(project(":data:local:room"))
            implementation(project(":data:remote:ktor"))
            implementation(project(":data:remote:snapi"))
            implementation(libs.kotlinx.coroutines.core)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation(project(":core:datetime"))
            implementation(project(":core:models-test"))
            implementation(project(":data:remote:ktor-test"))
            implementation(project(":data:remote:snapi-test"))
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

    namespace = "com.adammcneilly.spacenerd.data.article.impl"
}
