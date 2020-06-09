# DSL_Ofc_Working Demo
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
