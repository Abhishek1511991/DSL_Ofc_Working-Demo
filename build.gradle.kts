import org.apache.log4j.BasicConfigurator.configure
import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.setValue
import org.gradle.kotlin.dsl.repositories
import org.gradle.util.ConfigureUtil.configure
import org.jetbrains.kotlin.resolve.CompilerEnvironment.configure

buildscript {
    repositories {
        jcenter()
        google()
    }
    dependencies {
        "classpath"(Config.BuildPlugins.androidGradle)
        "classpath"(Config.BuildPlugins.kotlinGradlePlugin)
    }
}

allprojects
run {
    repositories {
        google()
        jcenter()
    }
}

/*tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
    }*/

task("clean").configure {
    delete("build")
}
 fun <T> Task.configure(t: T) {

}
