pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Space Nerd"
include(":app")
include(":core:data")
include(":core:models")
include(":core:ui:scaffold")
include(":data:article:api")
include(":data:article:impl")
include(":scaffold")
