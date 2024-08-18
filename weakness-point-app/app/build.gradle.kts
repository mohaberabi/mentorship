plugins {
    alias(libs.plugins.weakness.android.application.compose)
    alias(libs.plugins.weakness.hilt.android)
}

android {
    val appId = libs.versions.appId.get()
    namespace = appId
    compileSdk = libs.versions.androidCompileSdk.get().toInt()


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.navigation.compose)
    val designSystem = ":core:designsystem"
    val ui = ":core:ui"
    val data = ":core:data"
    val listing = ":listing"
    val addWeakness = ":add_weakness"
    val copyWeakness = ":copy_weakness"

    implementation(project(ui))
    implementation(project(designSystem))

    implementation(project(data))
    implementation(project(addWeakness))

    implementation(project(listing))
    implementation(project(copyWeakness))


}