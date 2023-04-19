plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id("org.jetbrains.compose")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

kotlin {
    android()
    sourceSets {
        val koinVersion = "3.3.2"
        val firebaseVersion = "31.4.0"

        val androidMain by getting {
            dependencies {
                implementation(project(":shared"))

                // DI Koin
                implementation("io.insert-koin:koin-android:$koinVersion")

                // Firebase
                implementation(platform("com.google.firebase:firebase-bom:$firebaseVersion"))
                implementation("com.google.firebase:firebase-crashlytics-ktx")
                implementation("com.google.firebase:firebase-analytics-ktx")
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "dev.mvlikhachev"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        applicationId = "dev.mvlikhachev"
        minSdk = (findProperty("android.minSdk") as String).toInt()
        targetSdk = (findProperty("android.targetSdk") as String).toInt()
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        jvmToolchain(11)
    }
}
