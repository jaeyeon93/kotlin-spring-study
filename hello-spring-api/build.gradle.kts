tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation(project(":support:logging"))
    implementation(project(":support:monitoring"))
    implementation(project(":domain"))
    runtimeOnly(project(":storage:db-main"))

    implementation("org.springframework.kafka:spring-kafka")
    implementation("org.springframework.boot:spring-boot-starter-web")
}
