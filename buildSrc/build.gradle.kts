plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    google()
}

val androidGradlePluginVersion: String by project

dependencies {
    implementation("com.android.tools.build:gradle:$androidGradlePluginVersion")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.5.1")
}
