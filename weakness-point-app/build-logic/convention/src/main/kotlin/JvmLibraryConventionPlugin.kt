import convention.configureKotlinJvm
import convention.implementation
import convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies


private const val jvmPlugin = "org.jetbrains.kotlin.jvm"

class JvmLibraryConventionPlugin : Plugin<Project> {


    override fun apply(target: Project) {


        with(target) {
            with(pluginManager) {
                apply(jvmPlugin)
            }
            configureKotlinJvm()
            dependencies {
                implementation(libs.findLibrary("kotlinx.coroutines").get())
            }
        }
    }
}