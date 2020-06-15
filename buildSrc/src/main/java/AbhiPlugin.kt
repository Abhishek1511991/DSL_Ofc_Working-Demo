import org.gradle.api.Plugin
import org.gradle.api.Project

import org.gradle.kotlin.dsl.*


class AbhiPlugin : Plugin<Project>
{
    override fun apply(target: Project) :Unit=target.run {

        tasks {
            register("abhi") {
                group = "sample"
                description = "Prints a description of ${project.name}."
                doLast {
                    println("I'm ${project.name}.")
                }
            }
        }
    }

}