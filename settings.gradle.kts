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
include(":core:displaymodels")
include(":core:models")
include(":data:article:api")
include(":data:article:impl")
include(":feature:news")
include(":scaffold")
include(":core:ui:components")
