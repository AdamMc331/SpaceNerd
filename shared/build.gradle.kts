import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.kmp.library)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.room)
}

kotlin {
    androidLibrary {
        compileSdk = libs.versions.compileSdk.get().toInt()
        minSdk = libs.versions.minSdk.get().toInt()

        namespace = "com.adammcneilly.spacenerd.shared"

        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    // Not building iOS because build times
    // and because I don't use it yet
//    listOf(
//        iosX64(),
//        iosArm64(),
//        iosSimulatorArm64(),
//    ).forEach { iosTarget ->
//        iosTarget.binaries.framework {
//            baseName = "SpaceNerdApp"
//            isStatic = true
//            linkerOpts.add("-lsqlite3") // Essential for iOS SQLite support
//        }
//    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.room.runtime.android)
            implementation(libs.koin.android)
            implementation(libs.ktor.client.android)
        }

        commonMain.dependencies {
            implementation(project(":core:datetime"))
            implementation(project(":core:deeplinks"))
            implementation(project(":core:designsystem"))
            implementation(project(":core:displaymodels"))
            implementation(project(":core:models"))
            implementation(project(":core:scaffold"))
            implementation(project(":data:agency:api"))
            implementation(project(":data:agency:impl"))
            implementation(project(":data:article:api"))
            implementation(project(":data:article:impl"))
            implementation(project(":data:astronauts:api"))
            implementation(project(":data:astronauts:impl"))
            implementation(project(":data:cache"))
            implementation(project(":data:expeditions:api"))
            implementation(project(":data:expeditions:impl"))
            implementation(project(":data:launch:api"))
            implementation(project(":data:launch:impl"))
            implementation(project(":data:local:room"))
            implementation(project(":data:remote:ktor"))
            implementation(project(":data:remote:snapi"))
            implementation(project(":data:remote:tsd"))
            implementation(project(":data:stations:api"))
            implementation(project(":data:stations:impl"))
            implementation(project(":feature:astronautdetail"))
            implementation(project(":feature:astronautlist"))
            implementation(project(":feature:launchdetail"))
            implementation(project(":feature:launchlist"))
            implementation(project(":feature:news"))
            implementation(project(":feature:stationlist"))
            implementation(project(":feature:stationdetail"))
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.navigation3.ui.kmp)
            implementation(libs.androidx.room.runtime)
            implementation(libs.coil.compose)
            implementation(libs.coil.ktor)
            implementation(libs.compose.material3.adaptive)
            implementation(libs.eygraber.compose.placeholder.material3)
            implementation(libs.jetbrains.compose.components.resources)
            implementation(libs.jetbrains.compose.foundation)
            implementation(libs.jetbrains.compose.material3)
            implementation(libs.jetbrains.compose.material.icons.extended)
            implementation(libs.jetbrains.compose.runtime)
            implementation(libs.jetbrains.compose.ui)
            implementation(libs.koin.compose.viewmodel.navigation)
            implementation(libs.koin.core)
            implementation(libs.kotlinx.datetime)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.material.kolor)
            implementation(libs.sqlite.bundled)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation(libs.google.testparameterinjector)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }
}

dependencies {
    // KSP configuration for Room code generation
    add("kspCommonMainMetadata", libs.androidx.room.compiler)
    add("kspAndroid", libs.androidx.room.compiler)
    // Add when we include iOS support
//    add("kspIosX64", libs.androidx.room.compiler)
//    add("kspIosArm64", libs.androidx.room.compiler)
//    add("kspIosSimulatorArm64", libs.androidx.room.compiler)
}

room {
    schemaDirectory("$projectDir/schemas")
}
