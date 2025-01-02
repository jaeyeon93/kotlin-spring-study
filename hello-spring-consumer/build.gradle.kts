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
    implementation(project(":support:monitoring"))
    implementation(project(":clients:client-sample"))
    implementation(project(":clients:client-admin-api"))
    implementation(project(":common:util"))
    runtimeOnly(project(":storage:db-main"))
}
