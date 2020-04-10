package dependencies

object App {

    object AndroidX {
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.KTX_CORE}"
        const val FRAGMENT = "androidx.fragment:fragment:${Versions.FRAGMENT}"
        const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}"
    }

    object Lifecycle {
        const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
    }

    object Coroutines {
        const val ANDROID =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
        const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    }

    object Dagger {
        const val ANDROID_COMPILER = "com.google.dagger:dagger-android-processor:${Versions.DAGGER}"
        const val ANDROID_RUNTIME = "com.google.dagger:dagger-android:${Versions.DAGGER}"
        const val COMPILER = "com.google.dagger:dagger-compiler:${Versions.DAGGER}"
        const val INFLATION_COMPILER =
            "com.squareup.inject:inflation-inject-processor:${Versions.DAGGER_ASSISTED}"
        const val INFLATION_RUNTIME =
            "com.squareup.inject:inflation-inject:${Versions.DAGGER_ASSISTED}"
        const val RUNTIME = "com.google.dagger:dagger:${Versions.DAGGER}"
    }

    object Kotlin {
        const val STD_LIB_JDK7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"
        const val STD_LIB_JDK8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"
    }

    object Lamah {
        const val PERMISSIONS = "com.lamah:permissions:${Versions.LAMAH}"
        const val PRESENTATION = "com.lamah:presentation:${Versions.LAMAH}"
        const val RETAINER = "com.lamah:retainer:${Versions.LAMAH}"
        const val VIEW_COROUTINES_SCOPE = "com.lamah:view-coroutine-scope:${Versions.LAMAH}"

        object Utils {
            const val PRESENTATION = "com.lamah:utils-presentation:${Versions.LAMAH}"
            const val ANDROID = "com.lamah:utils-android:${Versions.LAMAH}"
            const val COROUTINES = "com.lamah:utils-coroutines:${Versions.LAMAH}"
        }
    }

    object Mapbox {
        const val SDK = "com.mapbox.mapboxsdk:mapbox-android-sdk:${Versions.MAPBOX_SDK}"
        const val NAVIGATION =
            "com.mapbox.mapboxsdk:mapbox-android-navigation:${Versions.MAPBOX_NAVIGATION}"
    }

    object Room {
        const val RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
        const val COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
        const val COROUTINES = "androidx.room:room-ktx:${Versions.ROOM}"
        const val TEST = "androidx.room:room-testing:${Versions.ROOM}"
    }

    object Moshi {
        const val RUNTIME = "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI}"
        const val COMPILER = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.MOSHI}"
    }

    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    const val FOQA = "pl.droidsonroids.foqa:foqa:${Versions.FOQA}"
    const val LEAK_CANARY = "com.squareup.leakcanary:leakcanary-android:${Versions.LEAK_CANARY}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val SIMPLE_STACK = "com.github.Zhuinden:simple-stack:${Versions.SIMPLE_STACK}"
    const val FIREBASE_MESSAGING = "com.google.firebase:firebase-messaging:${Versions.FIREBASE_MESSAGING}"
    const val THREE_TEN_ABP = "com.jakewharton.threetenabp:threetenabp:${Versions.THREE_TEN_ABP}"
    // TODO: Remove library from project [TCA-115]
    const val RATING_BAR_VIEW = "com.github.ome450901:SimpleRatingBar:${Versions.RATING_BAR_VIEW}"
}
