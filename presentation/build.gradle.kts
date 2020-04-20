plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(Plugins.Detekt.id).version(Plugins.Detekt.version)
}

android {
    compileSdkVersion(Sdk.compile)
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    sourceSets {
        map { it.java.srcDir("src/${it.name}/kotlin") }
    }
    defaultConfig {
        applicationId = "es.babel.phonebook"
        minSdkVersion(Sdk.min)
        targetSdkVersion(Sdk.target)
        versionCode = Version.code
        versionName = Version.name
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    flavorDimensions("style")
    productFlavors {
        create("red") {
            setDimension("style")
            applicationIdSuffix = ".red"
        }

        create("blue") {
            setDimension("style")
            applicationIdSuffix = ".blue"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)

    implementation(Libraries.Ema.android)
    androidTestImplementation(Libraries.Ema.Testing.android)

    testImplementation(TestLibraries.junit)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)

    implementation(project(":domain"))
    implementation(project(":data"))
}