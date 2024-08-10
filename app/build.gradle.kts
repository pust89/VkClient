import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.pustovit.vkclient"
    compileSdk = 34
    buildToolsVersion = "33.0.1"

    defaultConfig {
        applicationId = "com.pustovit.vkclient"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())
        val vkIDRedirectScheme = properties.getProperty("VKIDRedirectScheme")
        val vkIdClientId = properties.getProperty("VKIDClientID")
        val vkIdClientSecret = properties.getProperty("VKIDClientSecret")

        manifestPlaceholders["VKIDRedirectHost"] = "vk.com"
        manifestPlaceholders["VKIDRedirectScheme"] = vkIDRedirectScheme
        manifestPlaceholders["VKIDClientID"] = vkIdClientId
        manifestPlaceholders["VKIDClientSecret"] = vkIdClientSecret

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }


    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    java{
        toolchain{
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

}

dependencies {
    implementation("com.google.dagger:dagger:2.51.1")
    kapt("com.google.dagger:dagger-compiler:2.51.1")

    implementation(project(mapOf("path" to ":injector")))
    implementation(project(mapOf("path" to ":models")))
    implementation(project(mapOf("path" to ":data_source_api")))
    implementation(project(mapOf("path" to ":data_source_impl")))
    implementation(project(mapOf("path" to ":data_api")))
    implementation(project(mapOf("path" to ":data_impl")))
    implementation(project(mapOf("path" to ":domain_api")))
    implementation(project(mapOf("path" to ":domain_impl")))
    implementation(project(mapOf("path" to ":screens")))
    implementation(project(mapOf("path" to ":ui_common")))
    implementation(project(mapOf("path" to ":navigation")))

    implementation(project(mapOf("path" to ":feature_splash_api")))
    implementation(project(mapOf("path" to ":feature_splash_impl")))

    implementation(project(mapOf("path" to ":feature_auth_api")))
    implementation(project(mapOf("path" to ":feature_auth_impl")))

    implementation(project(mapOf("path" to ":feature_news_api")))
    implementation(project(mapOf("path" to ":feature_news_impl")))

    implementation(project(mapOf("path" to ":feature_profile_api")))
    implementation(project(mapOf("path" to ":feature_profile_impl")))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.06.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}