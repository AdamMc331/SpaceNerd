pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://central.sonatype.com/repository/maven-snapshots/")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://central.sonatype.com/repository/maven-snapshots/")
    }
}

rootProject.name = "Space Nerd"
include(":app")
include(":core:datetime")
include(":core:designsystem")
include(":core:displaymodels")
include(":core:models")
include(":core:models-test")
include(":core:scaffold")
include(":data:agency:api")
include(":data:agency:impl")
include(":data:agency:test")
include(":data:article:api")
include(":data:article:impl")
include(":data:article:test")
include(":data:cache")
include(":data:launch:api")
include(":data:launch:impl")
include(":data:launch:test")
include(":data:local:room")
include(":data:remote:ktor")
include(":data:remote:ktor-test")
include(":data:remote:snapi")
include(":data:remote:tsd")
include(":data:remote:tsd-test")
include(":data:stations:api")
include(":data:stations:impl")
include(":data:stations:test")
include(":feature:astronautlist")
include(":feature:launchdetail")
include(":feature:launchlist")
include(":feature:news")
include(":feature:stationlist")
include(":shared")
include(":test:paparazzi")

plugins {
    id("org.jetbrains.kotlinx.kover.aggregation").version("0.9.1")
}

kover {
    enableCoverage()
}
