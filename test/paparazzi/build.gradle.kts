import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
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
    testImplementation(libs.compose.material3.adaptive)
    testImplementation(libs.google.testparameterinjector)
    testImplementation(libs.kotlinx.datetime)
}
