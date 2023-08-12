plugins {
    java
    war
    id("org.springframework.boot") version "3.2.0-SNAPSHOT"
    id("io.spring.dependency-management") version "1.1.2"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-web-services")

    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.2")

    // https://mvnrepository.com/artifact/com.h2database/h2
    implementation("com.h2database:h2:2.2.220")

    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-rest
    implementation("org.springframework.boot:spring-boot-starter-data-rest:3.1.2")
    implementation("au.com.dius:pact-jvm-provider-junit:4.0.10")
    implementation("au.com.dius:pact-jvm-provider-junit:4.0.10")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // https://mvnrepository.com/artifact/org.springframework/spring-test
    testImplementation("org.springframework:spring-test:6.0.11")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
