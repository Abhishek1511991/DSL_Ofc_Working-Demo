rootProject.buildFileName = "build.gradle.kts"

apply(from = "gradle/shared-with-buildSrc/build-cache-configuration.settings.gradle.kts")

includeBuild("app")

rootProject.name = "DSL_Study"

for (project in rootProject.children) {
    project.apply {
        projectDir = file("subprojects/$name")
        buildFileName = "$name.gradle.kts"
        require(projectDir.isDirectory) { "Project '${project.path} must have a $projectDir directory" }
        require(buildFile.isFile) { "Project '${project.path} must have a $buildFile build script" }
    }
}
