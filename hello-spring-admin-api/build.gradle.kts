tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation(project(":clients:client-sample"))
    implementation(project(":support:logging"))
    implementation(project(":domain"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    runtimeOnly(project(":storage:db-main"))
}
