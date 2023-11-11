plugins {
    `java-test-fixtures`
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperClass")
    annotation("javax.persistence.Embeddable")
}

dependencies {
    compileOnly(project(":domain"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("com.mysql:mysql-connector-j:8.1.0")

    testCompileOnly(project(":domain"))
}