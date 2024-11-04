plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.com.google.dagger.hilt.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.room)
}

android {
    namespace = "io.github.joaogouveia89.tikodog"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.github.joaogouveia89.tikodog"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {

    // AndroidX Core Libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

// Compose UI Libraries
    implementation(platform(libs.compose.bom)) // BOM for Compose versioning
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material.icons.extended)

// Image Loading Libraries
    implementation(libs.coil.compose) // Coil for Compose image loading
    implementation(libs.coil.network.okhttp) // Coil with OkHttp support

// Navigation Library
    implementation(libs.androidx.navigation.compose) // Compose navigation

// Material Design Components
    implementation(libs.androidx.material)

// Dependency Injection with Hilt
    implementation(libs.androidx.hilt.navigation.compose) // Hilt integration for Compose navigation
    implementation(libs.hilt.android) // Hilt Android library
    kapt(libs.hilt.compiler) // Hilt compiler for annotation processing

// Networking Libraries
    implementation(libs.retrofit) // Retrofit for networking
    implementation(libs.converter.gson) // Gson converter for Retrofit
    implementation(libs.okhttp) // OkHttp client
    implementation(libs.logging.interceptor) // Logging interceptor for OkHttp

// Testing Libraries
    testImplementation(libs.junit) // Unit testing with JUnit
    androidTestImplementation(libs.androidx.junit) // AndroidJUnit for instrumented tests
    androidTestImplementation(libs.androidx.espresso.core) // Espresso for UI testing
    androidTestImplementation(platform(libs.compose.bom)) // Compose BOM for tests
    androidTestImplementation(libs.androidx.ui.test.junit4) // UI testing with Compose

// Debugging Libraries
    debugImplementation(libs.androidx.ui.tooling) // UI tooling for debugging
    debugImplementation(libs.androidx.ui.test.manifest) // Manifest testing for Compose

//Room
    implementation(libs.room) // Room runtime
    kapt(libs.room.compiler)
    implementation(libs.room.kotlincoroutines) // Room extensions

// Kotlinx date time
    implementation(libs.kotlinx.datetime)
}