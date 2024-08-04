tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.kafka:spring-kafka")
    implementation(project(":support:logging"))
    implementation(project(":clients:client-sample"))

    runtimeOnly(project(":storage:db-main"))
}