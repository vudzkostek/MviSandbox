package dependencies

object App {

    object AndroidX {
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
        const val RECYCLER_VIEW =
            "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW}"
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.KTX_CORE}"
        const val LIFECYCLE_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:2.2.0-alpha01"
    }

    object Coroutines {
        const val ANDROID =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
        const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    }

    object Dagger {
        const val COMPILER = "com.google.dagger:dagger-compiler:${Versions.DAGGER}"
        const val INFLATION_COMPILER =
            "com.squareup.inject:inflation-inject-processor:${Versions.DAGGER_ASSISTED}"
        const val INFLATION_RUNTIME =
            "com.squareup.inject:inflation-inject:${Versions.DAGGER_ASSISTED}"
        const val RUNTIME = "com.google.dagger:dagger:${Versions.DAGGER}"
    }

    object Kotlin {
        const val STD_LIB_JDK7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"
    }
}
