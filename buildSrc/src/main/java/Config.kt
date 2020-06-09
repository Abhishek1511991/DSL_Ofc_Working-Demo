
//https://antonioleiva.com/kotlin-dsl-gradle/   ******
//https://github.com/antoniolg/Bandhook-Kotlin/ ******

private const val kotlinVersion = "1.3.72"
private const val androidGradleVersion = "4.1.0-alpha10"


// Compile dependencies
private const val appcompatVersion = "1.1.0"
private const val constraintlayoutVersion = "1.1.3"
private const val junitVersion = "4.12"
private const val junit_extVersion = "1.1.1"
private const val espresso_coreVersion = "3.2.0"

object Config
{

    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKept = "kotlin-kapt"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"

    object Android {
        val buildToolsVersion = "29.0.2"
        val minSdkVersion = 17
        val targetSdkVersion = 29
        val compileSdkVersion = 29
        val applicationId = "com.dishd2h.dsl_demo"
        val versionCode = 1
        val versionName = "0.1"
    }

    object BuildPlugins {
        val androidGradle = "com.android.tools.build:gradle:$androidGradleVersion"
        val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    }

    object Libs {

        val kotlin_std = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
        val appcompat = "androidx.appcompat:appcompat:$appcompatVersion"
        val constraintlayout = "androidx.constraintlayout:constraintlayout:$constraintlayoutVersion"

    }

    object TestLibs {
       /* val junit = "junit:junit:4.12"
        val espresso = "com.android.support.test.espresso:espresso-core:2.2.2"*/

        val junit = "junit:junit:$junitVersion"
        val junit_EXT = "androidx.test.ext:junit:$junit_extVersion"
        val espresso_core = "androidx.test.espresso:espresso-core:$espresso_coreVersion"
    }

    //implementation fileTree(dir: 'libs', include: ['*.jar'])
}