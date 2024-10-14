plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = Configs.sourceCompatibility
    targetCompatibility = Configs.targetCompatibility
}
dependencies {
    api(project(mapOf("path" to ":models")))
    api(project(mapOf("path" to ":injector")))
    api(project(mapOf("path" to ":data_api")))
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1-Beta")
}