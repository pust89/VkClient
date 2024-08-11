import org.gradle.api.JavaVersion
import org.gradle.jvm.toolchain.JavaLanguageVersion

/**
 * Created by Pustovit V.V.
 * Date: 11.08.2024
 * Time: 15:27
 */
object Configs {
    const val applicationId = "com.pustovit.vkclient"
    const val minSdk = 28
    const val compileSdk = 34
    const val targetSdk = 34
    const val versionCode = 1
    const val versionName = "1.0"
    const val jvmTarget = "17"
    const val kotlinCompilerExtensionVersion = "1.4.3"

    val languageVersion = JavaLanguageVersion.of(17)
    val sourceCompatibility = JavaVersion.VERSION_17
    val targetCompatibility = JavaVersion.VERSION_17
}