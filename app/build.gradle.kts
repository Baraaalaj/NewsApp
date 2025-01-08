plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp") // ksp
    id("androidx.navigation.safeargs.kotlin") // Safe Args plugin
}

android {
    namespace = "com.example.newsapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.newsapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // المكونات الأساسية
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // المكونات المعمارية
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.runtime.ktx)

    // Room
    implementation(libs.androidx.room.runtime)  // المكتبة الأساسية لـ Room
    ksp(libs.androidx.room.compiler)           // مكتبة Room الخاصة بـ KSP
    implementation(libs.androidx.room.ktx)     // مكتبة Room لـ Kotlin Extensions

    // coroutines
    implementation(libs.jetbrains.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)

    // مكونات التنقل
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // Glide
    implementation(libs.glide)
    ksp(libs.compiler)
}