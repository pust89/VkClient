plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id ("kotlin-kapt")
}

java {
    sourceCompatibility = Configs.sourceCompatibility
    targetCompatibility = Configs.targetCompatibility
}
dependencies {
    api(project(mapOf("path" to ":domain_api")))
    implementation( "com.google.dagger:dagger:2.51.1")
    kapt("com.google.dagger:dagger-compiler:2.51.1")
}