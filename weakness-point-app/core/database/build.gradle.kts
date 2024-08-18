plugins {

    alias(libs.plugins.weakness.android.library)
    alias(libs.plugins.weakness.android.room)
    alias(libs.plugins.weakness.hilt.android)

}

android {
    namespace = libs.versions.appDomain.get() + ".core.database"
}

dependencies {

    implementation(project(":core:domain"))


}