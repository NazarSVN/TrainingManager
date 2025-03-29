plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.training_manager"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.training_manager"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

buildscript {
    repositories {
        mavenCentral()
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.animation.core.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.core.splashscreen)
    implementation (libs.viewpager2)
    implementation ("com.android.support.constraint:constraint-layout:1.1.3")

    implementation ("io.github.ShawnLin013:number-picker:2.4.13")

}