allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperClass")
    annotation("javax.persistence.Embeddable")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-data-jpa")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("com.mysql:mysql-connector-j:8.1.0")
}