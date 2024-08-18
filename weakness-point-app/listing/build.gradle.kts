plugins {


    alias(libs.plugins.weakness.android.feature.compose)
    alias(libs.plugins.kotlin.serialization)
}


android {


    namespace = libs.versions.appDomain.get() + ".feature.listing"
}

dependencies {
    implementation(project(":core:domain"))
    implementation(libs.kotlin.serialization.json)
    implementation(libs.androidx.navigation.compose)


}