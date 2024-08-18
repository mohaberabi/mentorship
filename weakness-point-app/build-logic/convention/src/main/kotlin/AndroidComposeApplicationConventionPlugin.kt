import com.android.build.api.dsl.ApplicationExtension
import convention.configureAndroidComposeLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidComposeApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {


        with(target) {
            with(pluginManager) {
                apply("weakness.android.application")
            }

            extensions.configure<ApplicationExtension> {
                configureAndroidComposeLibrary(this)
            }
        }
    }
}