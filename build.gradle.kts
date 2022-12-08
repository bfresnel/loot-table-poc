import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.sonarqube") version "3.4.0.2513"
    kotlin("jvm") version "1.7.20"
    kotlin("plugin.spring") version "1.7.20"
    kotlin("plugin.jpa") version "1.7.20"
}

group = "fr.bfr"
version = "2.1.1"
java.sourceCompatibility = JavaVersion.VERSION_16


configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

sourceSets.main {
    java.srcDirs("src/main/kotlin", "src/main/java")
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.24")
    runtimeOnly("org.postgresql:postgresql")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.0")
    implementation("ch.qos.logback:logback-core:1.2.11")
    implementation("org.slf4j:slf4j-api:1.7.36")
    implementation("ch.qos.logback:logback-classic:1.2.11")
    implementation("org.liquibase:liquibase-core")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    
    testCompileOnly("org.projectlombok:lombok:1.18.24")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
    testImplementation("com.h2database:h2:2.1.214")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    
    annotationProcessor("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.24")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.getByName<Jar>("jar") {
    enabled = false
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = JavaVersion.VERSION_16.toString()
    }
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

sonarqube {
    properties {
        properties(
                mapOf<String, Any>(
                        "sonar.projectKey" to "bfresnel_loot-table-poc",
                        "sonar.organization" to "bfresnel",
                        "sonar.host.url" to "https://sonarcloud.io",
                )
        )
    }
}
