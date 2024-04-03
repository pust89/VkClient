plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies {
    api(project(mapOf("path" to ":models")))
    api(project(mapOf("path" to ":injector")))
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1-Beta")
}