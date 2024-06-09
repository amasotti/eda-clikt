plugins {
    kotlin("jvm") version "2.0.0"
    id("io.gitlab.arturbosch.detekt").version("1.23.6")
    application
}

group = "learning.toni"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.ajalt.clikt:clikt:4.4.0")
    implementation("org.jetbrains.kotlinx:dataframe:0.13.1")

    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-runner-junit5:5.9.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

application {
    mainClass = "edaclikt.MainKt"
}

