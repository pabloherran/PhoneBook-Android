plugins {
    id(BuildPlugins.kotlin)
    id(Plugins.Detekt.id).version(Plugins.Detekt.version)
}

dependencies {
    implementation(Libraries.kotlinStdLib)

    implementation(Libraries.coroutines)

    implementation(Libraries.Ema.core)
    testImplementation(Libraries.Ema.Testing.core)

    testImplementation(TestLibraries.junit)
}