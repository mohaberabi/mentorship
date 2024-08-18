plugins {
    alias(libs.plugins.weakness.compose.android.library)

}


android {
    namespace = libs.versions.appDomain.get() + ".core.designsystem"
}