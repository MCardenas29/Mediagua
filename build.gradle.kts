import com.android.utils.TraceUtils.simpleId
import org.jetbrains.kotlin.gradle.plugin.extraProperties

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.devtools.kps) apply false
    alias(libs.plugins.compose.compiler) apply false
}