plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.beautycare"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.beautycare"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures{
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.camera.view)
    implementation(libs.camera.lifecycle)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // codigo para implementar animaciones de gif
    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.25")
    // codigo para implementar conexion HTTP
    implementation("com.android.volley:volley:1.2.1")
    implementation ("androidx.camera:camera-camera2:1.1.0")
    implementation ("pub.devrel:easypermissions:3.0.0")

}



