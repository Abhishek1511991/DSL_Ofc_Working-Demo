import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.setValue
import org.gradle.kotlin.dsl.repositories


plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

application {
    mainClassName="com.dishd2h.dsl_demo.MainActivity"
}

android {

    compileSdkVersion(Config.Android.compileSdkVersion)
    buildToolsVersion(Config.Android.buildToolsVersion)
    
   
  
    defaultConfig {
        applicationId = Config.Android.applicationId
        minSdkVersion(Config.Android.minSdkVersion)
        targetSdkVersion(Config.Android.targetSdkVersion)
        versionCode = Config.Android.versionCode
        versionName = Config.Android.versionName
        
        setProperty("archivesBaseName", "$applicationId-v$versionName($versionCode)")
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        
    }
    
    buildTypes
    {
    
        getByName("debug")
        {
            isMinifyEnabled=false
            proguard =false
            proguardFiles("proguard-rules.pro")
        }
        
         getByName("release") {
                    isMinifyEnabled = false
                    proguardFiles("proguard-rules.pro")
                }
    }
    
    
    
    
}


dependencies
{
     implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Config.Libs.kotlin_std)
    implementation(Config.Libs.appcompat)
    implementation(Config.Libs.constraintlayout)
    
    testImplementation(Config.TestLibs.junit)
    testImplementation(Config.TestLibs.junit_EXT)
    androidTestImplementation(Config.TestLibs.espresso_core)
     
}
