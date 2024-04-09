plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
}

android {
    namespace = "com.pustovit.vkclient.data_local_source_impl"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

}

dependencies {
    implementation(project(mapOf("path" to ":data_local_source_api")))
    implementation( "com.google.dagger:dagger:2.51.1")
    implementation( "com.google.code.gson:gson:2.10.1")
    implementation( "androidx.core:core-ktx:1.12.0")
    kapt("com.google.dagger:dagger-compiler:2.51.1")
}