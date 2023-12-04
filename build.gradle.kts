// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("org.jlleitschuh.gradle.ktlint") version "12.0.2"
}

buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("org.jlleitschuh.gradle:ktlint-gradle:12.0.2")
    }
}

apply(plugin = "org.jlleitschuh.gradle.ktlint")

tasks.withType<org.jlleitschuh.gradle.ktlint.tasks.GenerateReportsTask> {
    reportsOutputDirectory.set(
        project.layout.buildDirectory.dir("other/location/$name"),
    )
}
