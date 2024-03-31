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
include(":data_impl")
include(":models")
include(":domain_impl")
include(":ui_common")
include(":navigation")
include(":injector")

// Features
include(":news_api")
include(":news_impl")

include(":data_api")
include(":domain_api")
