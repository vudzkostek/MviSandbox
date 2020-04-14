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

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            val args = mutableListOf(
                "-Xuse-experimental=kotlin.contracts.ExperimentalContracts",
                "-Xopt-in=kotlin.RequiresOptIn",
                "-Xuse-experimental=kotlin.time.ExperimentalTime",
                "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-Xopt-in=kotlinx.coroutines.FlowPreview",
                "-Xinline-classes"
            )

            args.addAll(freeCompilerArgs)

            freeCompilerArgs = args
        }
    }
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

    viewBinding.isEnabled = true
}