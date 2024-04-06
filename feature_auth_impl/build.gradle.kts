import java.util.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
}

android {
    namespace = "com.pustovit.vkclient.auth_imp"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

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

        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
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
}

dependencies {

    // Если используете One Tap на Compose, укажите эту зависимость.
    implementation(project(mapOf("path" to ":feature_auth_api")))

    implementation( "com.google.dagger:dagger:2.51.1")
    kapt("com.google.dagger:dagger-compiler:2.51.1")

    implementation("com.vk.id:onetap-compose:1.3.1")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}