const val kotlinVersion = "1.3.71"

object BuildPlugins {

    private object Versions {
        const val buildToolsVersion = "3.6.2"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlin = "kotlin"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
}

object Plugins {

    object Detekt {
        const val id = "io.gitlab.arturbosch.detekt"
        const val version = "1.7.4"
    }

}

object Version {
    const val code = 1
    const val name = "1.0.0"
}

object Sdk {
    const val min = 23
    const val compile = 29
    const val target = compile
}

object Libraries {

    private object Versions {
        const val jetpack = "1.1.0"
        const val constraintLayout = "1.1.3"
        const val ktx = "1.2.0"
        const val ema = "2.3.0"
        const val kodein = "6.5.1"
        const val coroutines = "1.3.0"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"

    const val kodein = "org.kodein.di:kodein-di-generic-jvm:${Versions.kodein}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    object Ema {
        const val core = "com.github.babel-cdm.ema:easymvvm-core:${Versions.ema}"
        const val android = "com.github.babel-cdm.ema:easymvvm-android:${Versions.ema}"
        object Testing {
            const val core = "com.github.babel-cdm.ema:easymvvm-testing-core:${Versions.ema}"
            const val android = "com.github.babel-cdm.ema:easymvvm-testing-android:${Versions.ema}"
        }
    }
}

object TestLibraries {

    private object Versions {
        const val junit = "1.1.1"
        const val espresso = "3.2.0"
    }

    const val junit = "androidx.test.ext:junit:${Versions.junit}"
    const val testRunner = "androidx.test:runner:${Versions.junit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}