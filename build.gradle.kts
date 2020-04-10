buildscript {
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath(Classpaths.ANDROID)
        classpath(Classpaths.KOTLIN)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}

subprojects {
    project.plugins.configureAndroid(project)
}

fun PluginContainer.configureAndroid(project: Project) {
    whenPluginAdded {
        if (this is com.android.build.gradle.BasePlugin) {
            project.extensions
                .getByType<com.android.build.gradle.BaseExtension>()
                .apply {
                    applyAndroidCommons()
                }
        }
    }
}

fun com.android.build.gradle.BaseExtension.applyAndroidCommons() {
    compileSdkVersion(BuildConfig.COMPILE_SDK)

    defaultConfig {
        minSdkVersion(BuildConfig.MIN_SDK)
        targetSdkVersion(BuildConfig.TARGET_SDK)
    }
}