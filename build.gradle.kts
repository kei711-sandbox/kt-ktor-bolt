plugins {
    kotlin("jvm") version "1.5.0"
}

group = "com.example"
version = "0.0.1"

repositories {
    mavenCentral()
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
    }

    dependencies {
        "api"(kotlin("stdlib-jdk8"))
        "api"(kotlin("reflect"))
    }

    listOf("compileKotlin", "compileTestKotlin").forEach {
        tasks.named<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>(it) {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
}
