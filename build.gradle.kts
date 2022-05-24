plugins {
    id("java")
    id("application")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "fr.bfr"
version = "1.0.0"

repositories {
    mavenCentral()
}

application {
    mainClass.set("fr.bfr.Main")
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.3")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testCompileOnly("org.projectlombok:lombok:1.18.24")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.24")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes(
            "Main-class" to "fr.bfr.Main",
            "Class-Path" to configurations.runtimeClasspath.get()
                .filter { it.isFile }
                .joinToString(" ") { it.name }
        )
    }
}

tasks.shadowJar {
    archiveBaseName.set(rootProject.name)
    archiveVersion.set(project.version.toString())
    archiveClassifier.set("")
}
