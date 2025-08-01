plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.cash.paparazzi)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.google.dagger.hilt)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.adammcneilly.spacenerd"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.compileSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    namespace = "com.adammcneilly.spacenerd"
}

dependencies {
    implementation(platform(libs.compose.bom))
    implementation(project(":core:designsystem"))
    implementation(project(":core:displaymodels"))
    implementation(project(":core:scaffold"))
    implementation(project(":data:local:room"))
    implementation(project(":feature:astronautlist"))
    implementation(project(":feature:launchdetail"))
    implementation(project(":feature:launchlist"))
    implementation(project(":feature:news"))
    implementation(project(":feature:stationlist"))
    implementation(project(":shared"))
    implementation(libs.android.material)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.adaptive.android)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.androidx.room.runtime)
    implementation(libs.bundles.androidx.xr)
    implementation(libs.coil.compose)
    implementation(libs.coil.okhttp)
    implementation(libs.compose.material)
    implementation(libs.compose.material.icons.extended)
    implementation(libs.compose.navigation)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling)
    implementation(libs.eygraber.compose.placeholder.material3)
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.core)
    implementation(libs.square.moshi.kotlin)
    implementation(libs.square.okhttp.logging.interceptor)
    implementation(libs.square.retrofit)
    implementation(libs.square.retrofit.converter.moshi)

    debugImplementation(platform(libs.compose.bom))
    debugImplementation(libs.compose.ui.test.manifest)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.square.leakcanary)

    testImplementation(libs.google.testparameterinjector)
    testImplementation(libs.junit)

    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.compose.ui.test.junit)
    androidTestImplementation(libs.hilt.android.testing)

    ksp(libs.hilt.compiler)
    ksp(libs.square.moshi.kotlin.codegen)

    kspAndroidTest(libs.hilt.android.compiler)
}
