dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("io.github.openfeign:feign-micrometer")
    implementation("io.github.openfeign:feign-hc5")

    testImplementation("org.springframework.cloud:spring-cloud-contract-wiremock")
}
