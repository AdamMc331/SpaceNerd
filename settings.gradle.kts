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
include(":core:data:ktor")
include(":core:datetime")
include(":core:displaymodels")
include(":core:models")
include(":core:ui:components")
include(":core:ui:scaffold")
include(":scaffold")
