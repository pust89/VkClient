plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.pustovit.vkclient.data_source_impl"
    compileSdk = Configs.compileSdk

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = Configs.sourceCompatibility
        targetCompatibility = Configs.targetCompatibility
    }

}

dependencies {
    implementation(project(mapOf("path" to ":data_source_api")))
    implementation("com.google.dagger:dagger:2.51.1")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("androidx.core:core-ktx:1.12.0")
    kapt("com.google.dagger:dagger-compiler:2.51.1")

    val retrofitVersion = "2.9.0" // Retrofit with Moshi Converter
    val moshiVersion = "1.12.0" // Moshi
    val loggingInterceptorVersion = "4.12.0"   // okhttp3 and logging-interceptor
    /* Retrofit */
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-moshi:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion")

    /* Moshi */
    implementation("com.squareup.okhttp3:logging-interceptor:$loggingInterceptorVersion")
    /* Moshi */
    implementation("com.squareup.moshi:moshi:$moshiVersion")
    implementation("com.squareup.moshi:moshi-kotlin:$moshiVersion")

}