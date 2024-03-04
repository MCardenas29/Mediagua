import java.util.Properties

plugins {
    id("com.google.devtools.ksp")
    id("com.android.application")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "mx.mcardenas.mediagua"
    compileSdk = 34

    buildFeatures {
        buildConfig = true
        dataBinding = true
    }

    defaultConfig {
        applicationId = "mx.mcardenas.mediagua"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val localProps = Properties()
        localProps.load(project.rootProject.file("local.properties").inputStream())
        buildConfigField("String", "TWILO_ID", localProps.getProperty("twilo.id").toString())
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // implementation("com.twilio:voice-android:5.7.2")
    ksp("com.google.dagger:hilt-android-compiler:2.44")
    implementation("com.google.dagger:hilt-android:2.44")
    implementation("androidx.navigation:navigation-fragment:2.7.7")
    implementation("androidx.navigation:navigation-ui:2.7.7")
    implementation("io.particle:cloudsdk:1.0.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

