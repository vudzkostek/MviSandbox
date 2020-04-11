import dependencies.App

plugins {
    id(GradlePlugins.APPLICATION)
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    defaultConfig {
        applicationId = BuildConfig.APPLICATION_ID

        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        named("release").configure {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(App.Kotlin.STD_LIB_JDK7)
    implementation(App.AndroidX.APP_COMPAT)
    implementation(App.AndroidX.RECYCLER_VIEW)
    implementation(App.AndroidX.CORE_KTX)
    implementation(App.AndroidX.CONSTRAINT_LAYOUT)
    implementation(App.AndroidX.LIFECYCLE_KTX)
    implementation(App.Coroutines.CORE)
    implementation(App.Coroutines.ANDROID)
    implementation(App.Dagger.RUNTIME)
    kapt(App.Dagger.COMPILER)
    implementation(App.Dagger.INFLATION_RUNTIME)
    kapt(App.Dagger.INFLATION_COMPILER)
}
