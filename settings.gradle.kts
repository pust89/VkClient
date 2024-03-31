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

rootProject.name = "VkClient"


// Core
include(":app")
include(":assambly")
include(":data")
include(":models")
include(":domain")
include(":ui_common")
include(":navigation")

// Features
include(":news_api")
include(":news_impl")

