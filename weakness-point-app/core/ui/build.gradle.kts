plugins {
    alias(libs.plugins.weakness.compose.android.library)
}
android {
    namespace = libs.versions.appDomain.get() + ".core.ui"
}


dependencies {
    val designModule = ":core:designsystem"
    val domain = ":core:domain"
    implementation(project(domain))

    implementation(project(designModule))
}