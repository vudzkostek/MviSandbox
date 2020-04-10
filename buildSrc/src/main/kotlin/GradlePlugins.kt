import dependencies.Versions

object GradlePlugins {
    const val APPLICATION = "com.android.application"
    const val LIBRARY = "com.android.library"
}

object Classpaths {
    var ANDROID = "com.android.tools.build:gradle:${Versions.ANDROID_PLUGIN}"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    const val LOCALIZATION =
        "gradle.plugin.pl.droidsonroids.gradle.localization:android-gradle-localization-plugin:${Versions.LOCALIZATION_PLUGIN}"
    const val VERSIONS = "com.github.ben-manes:gradle-versions-plugin:${Versions.VERSIONS_PLUGIN}"
    const val GOOGLE_SERVICES = "com.google.gms:google-services:${Versions.GOOGLE_SERVICES_PLUGIN}"
}
