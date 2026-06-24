import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.cash.paparazzi)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.compose)
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
    }
}

android {
    namespace = "com.adammcneilly.spacenerd.test.paparazzi"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    kotlin.compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    testImplementation(platform(libs.compose.bom))
    testImplementation(kotlin("test"))
    testImplementation(project(":core:datetime"))
    testImplementation(project(":core:designsystem"))
    testImplementation(project(":core:displaymodels"))
    testImplementation(project(":core:models"))
    testImplementation(project(":core:models-test"))
    testImplementation(project(":core:scaffold"))
    testImplementation(project(":feature:launchlist"))
    testImplementation(project(":feature:launchdetail"))
    testImplementation(project(":feature:news"))
    testImplementation(project(":feature:stationdetail"))
    testImplementation(project(":feature:stationlist"))
    testImplementation(libs.compose.material)
    testImplementation(libs.compose.ui)
    testImplementation(libs.google.testparameterinjector)
    testImplementation(libs.kotlinx.datetime)
}
