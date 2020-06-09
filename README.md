# DSL_Ofc_Working Demo



# Below are the Steps must be follow if ypur want to start on Kotlin DLS ..

Step 1: Update Setting.gradle to setting.gradle.kts
Step 2: Remove existing setting.gradle and updated file write as rootProject.name = "project Name" include ("app","","",etc)
Step 3: Create a folder buildSrc where we but Gradle file setting.
Step 4: Create build.gradle.kts file and write below text and Sync project
		repositories {
			jcenter()
		}
		plugins {
			`kotlin-dsl`
		}
Step 5: Create file Config.kt under buildSrc folder (src/main/java/Config.kt) 
			object Config
			{
			}
			
Step 6: Open Gradle setting from Right Side in android Studio and Off "Toggle Offline Mode"

Step 7: Convert All Gradle App / project into the gradle.kts and Import All dependency from Config file

Step 8: Convert Project level Gradle and App Level gradle to gradle.kts and do specified changes according to Kts


#Part 1 :
------------------------------------------------------------------------------------------------
It has been a long time since we wrote a Gradle with a script called Groovy, but finally, there is something new 😮.
Kotlin DSL comes with autocomplete, navigation to resource, checking error at compile time and make code readable. 

How to use Kotlin script on Gradle? Just follow the steps.
FYI, when writing this I use com.android.tools.build:gradle:3.5.0 and on gradle-wrapper 5.4.1
Step 1 — Create buildSrc

buildSrc folder
Let’s start with create buildSrc on your root folder include two files, first build.gradle.kts

import org.gradle.kotlin.dsl.`kotlin-dsl`
plugins {
    `kotlin-dsl`
}
repositories {
    jcenter()
}

then Dependencies.kt on src/main/java

Dependencies.kt
and try Sync Project with Gradle Files

Step 2 — Convert settings.gradle
Rename settings.gradle to settings.gradle.kts and now you can use kotlin scripts
Before
include ':app', ':data', ':framework'
After
include(":app", ":framework", ":data")


Step 3 — Convert build.gradle Project
Rename again build.gradle to build.gradle.kts and change dependencies block before
dependencies {
    classpath 'com.android.tools.build:gradle:3.5.0'
    classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
}
After
dependencies {
    classpath("com.android.tools.build:gradle:${Versions.gradle}")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
}
for task clean block before
task clean(type: Delete) {
    delete rootProject.buildDir
}
After
tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}
repositories block before
repositories {
    google()
    jcenter()
    maven{ url 'https://jitpack.io' }
}
After
repositories {
    google()
    jcenter()
    maven { url = uri("https://jitpack.io") }
}


Step 4 — Convert build.gradle App
Now you will start to get confused for scripts that are quite complex 😨 rename build.gradle to build.gradle.kts
On plugin block before
apply plugin: 'com.android.application'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'
apply plugin: 'kotlin-kapt'
After
plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}
If you use kotlin() use must change dash(-) with dot(.) or you can still use dash like id(“kotlin-android-extensions”)
defaultConfig block

defaultConfig
the basic thing when you change Gradle using Kotlin script is the use of single-quotes to double-quotes. For minSdkVersion and targetSdkVersion is function and you can put parameter from Dependencies.kt, but for versionCode and versionName is variable.
dataBinding, bundle, lintOptions, and packagingOptions block

signingConfigs block

buildTypes and testOptions block

dependencies block

Yey! Sync project and your project is converted in Kotlin build scripts. As you can see, we can use implementation with the value from Dependencies.kt this makes our Gradle cleaner.
It could be that your project is more complicated, but it’s only a matter of time until you get used to it. 😎


#Part 2 :
-----------------------------------------------------------------------------------------------

 Let's go step by step on how we can achieve this.
Step 1: CreatebuildSrcdirectory
When creating a new project, Android Studio automatically generates two build.gradle files. One for the project configuration and other for the module configuration (app module)
We should organize dependencies in such a way that they can be managed throughout the project from one common place. This will also help managing dependencies in modular projects as they have many modules and different modules can have common dependencies. If two modules have the same dependency and both have different version then it can introduce subtle behaviour differences into the app. It is good to avoid these kinds of problems, and the best way to do that is to ensure that we consistently use the same version of any given third-party dependency throughout the app.
Creating buildSrc directory in the root directory of the project will help us solve our problem

This directory is a Gradle feature that enables to define tasks and tools which can be available throughout the build scripts, and we can use this to make our version information available throughout our build scripts. We can also use Kotlin within this directory by specifying the kotlin-dsl plugin in the build config for the buildSrc directory as explained in the next step.
Check the Gradle documentation for buildSrc here
CreatebuildSrcdirectory, then create two files inside buildSrc directory in the package structure as shown in the image below:
build.gradle.kts
Dependencies.kt (Inside src/main/kotlin package)

Step 2: Apply kotlin-dsl plugin in build.gradle.kts

It applies the kotlin-dsl, declares the repository from which this plugin can be obtained, and disables a warning that it is experimental.
This file has a .kts suffix, which indicates to Gradle that this file is a Kotlin script and not a Groovy one.
Step 3: Add values to Dependencies.kt

This is just a Kotlin file that contains singleton classes which includes version numbers and the dependencies used throughout the project. Dependencies organized in proper way makes it very easy to manage them from one common place.
Step 4: Convert build.gradle files and update with values from Dependencies.kt
Rename project level “build.gradle” file with “build.gradle.kts”. Update the classpath inside the dependencies block with the values from “Dependencies.kt” and convert the Gradle clean task to Kotlin syntax. Now the updated file will look like below:

Similarly, rename app level “build.gradle” file with “build.gradle.kts” and update the values from dependencies.kt as shown below

Here we have a single plugins block and id is actually a function call, so the arguments are in parentheses. This is a common thing that is required throughout the conversion process.
Finally, we can get auto suggestions now in our Gradle file.


# Below are the other links for Kotlin DSL References Material..

https://www.droidcon.com/news-detail?content-id=/repository/collaboration/Groups/spaces/droidcon_hq/ Documents/public /news /android-news/Converting%20your%20Android%20Gradle%20scripts%20to%20Kotlin

https://kotlinlang.org/docs/reference/using-gradle.html

https://medium.com/@napperley/gradle-kotlin-dsl-tutorial-223370af9cd8

https://proandroiddev.com/the-new-way-of-writing-build-gradle-with-kotlin-dsl-script-8523710c9670

https://docs.gradle.org/current/userguide/kotlin_dsl.html#sec:multi_project_builds

https://docs.gradle.org/current/userguide/kotlin_dsl.html#kotdsl:containers

https://docs.gradle.org/current/userguide/kotlin_dsl.html#type-safe-accessors

https://docs.gradle.org/current/userguide/organizing_gradle_projects.html#sec:build_sources
