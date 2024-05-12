import java.net.URI




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
        maven {
            url = URI("https://artifactory-external.vkpartner.ru/artifactory/vkid-sdk-andorid/")
        }
    }
}

rootProject.name = "VkClient"
include(":secrets.gradle.kts")

// Core
include(":app")
include(":data_source_impl")
include(":data_source_api")
include(":data_api")
include(":data_impl")
include(":models")
include(":domain_api")
include(":domain_impl")
include(":ui_common")
include(":screens")
include(":navigation")
include(":injector")

// Features
include(":feature_splash_api")
include(":feature_splash_impl")
include(":feature_auth_impl")
include(":feature_auth_api")
include(":feature_news_api")
include(":feature_news_impl")



