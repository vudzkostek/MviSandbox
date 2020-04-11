import dependencies.Versions

object GradlePlugins {
    const val APPLICATION = "com.android.application"
    const val LIBRARY = "com.android.library"
}

object Classpaths {
    var ANDROID = "com.android.tools.build:gradle:${Versions.ANDROID_PLUGIN}"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
}
