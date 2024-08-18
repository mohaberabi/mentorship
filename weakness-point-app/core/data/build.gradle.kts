plugins {
    alias(libs.plugins.weakness.android.library)
    alias(libs.plugins.weakness.hilt.android)
}


android {
    namespace = libs.versions.appDomain.get() + ".core.data"
}

dependencies {
    val database = ":core:database"
    val domain = ":core:domain"
    implementation(project(domain))
    implementation(project(database))


}