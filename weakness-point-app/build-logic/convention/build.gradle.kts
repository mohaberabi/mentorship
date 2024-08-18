import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = libs.versions.appDomain.get() + ".build-logic"
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}
tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}
dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        AppPlugins.values().forEach {
            register(it.label) {
                id = it.id
                implementationClass = it.impl
            }
        }

    }
}
enum class AppPlugins(
    val label: String,
    val id: String,
    val impl: String,
) {
    AndroidLibrary(
        label = "androidLibraryConventionPlugin",
        id = "weakness.android.library",
        impl = "AndroidLibraryConventionPlugin"
    ),
    JvmLibrary(
        label = "jvmLibraryConventionPlugin",
        id = "weakness.jvm.library",
        impl = "JvmLibraryConventionPlugin",
    ),
    HiltAndroid(
        label = "hiltAndroidConventionPlugin",
        id = "weakness.hilt.android",
        impl = "AndroidHiltConventionPlugin",
    ),
    ComposeLibrary(
        label = "androidLibraryComposeConventionPlugin",
        id = "weakness.compose.android.library",
        impl = "AndroidLibraryComposeConventionPlugin",
    ),
    FeatureLibrary(
        label = "androidFeatureConventionPlugin",
        id = "weakness.android.feature.library",
        impl = "AndroidFeatureConventionPlugin",
    ),
    FeatureComposeLibrary(
        label = "androidFeatureCompose",
        id = "weakness.android.feature.compose",
        impl = "AndroidFeatureComposeConventionPlugin",
    ),
    AndroidApplication(
        label = "androidApplicationConventionPlugin",
        id = "weakness.android.application",
        impl = "AndroidApplicationConventionPlugin",
    ),
    AndroidComposeApplication(
        label = "androidComposeApplicationConventionPlugin",
        id = "weakness.android.application.compose",
        impl = "AndroidComposeApplicationConventionPlugin",
    ),
    AndroidRoom(
        label = "androidRoomConventionPlugin",
        id = "weakness.android.room",
        impl = "AndroidRoomConventionPlugin",
    ),

}
