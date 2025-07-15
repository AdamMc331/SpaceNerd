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
include(":data:agency")
include(":data:article")
include(":data:cache")
include(":data:launch")
include(":data:local:room")
include(":data:remote:ktor")
include(":data:remote:snapi")
include(":data:remote:tsd")
include(":shared")
