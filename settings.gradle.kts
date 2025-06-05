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
include(":core:displaymodels")
include(":core:models")
include(":core:ui:components")
include(":core:ui:scaffold")
include(":data:article:api")
include(":data:article:impl")
include(":feature:news")
include(":data:cache:api")
include(":data:cache:impl")
