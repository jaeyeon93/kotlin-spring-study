rootProject.name = "hello-spring"

include(
    "hello-spring-api",
    "hello-spring-admin-api",
    "hello-spring-consumer",
    "support:logging",
    "support:monitoring",
    "storage:db-main",
    "clients:client-sample",
    "domain"
)

pluginManagement {
    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
    val ktLinter: String by settings

    resolutionStrategy {
        eachPlugin {
            when(requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.kapt" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.spring" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.jpa" -> useVersion(kotlinVersion)
                "org.springframework.boot" -> useVersion(springBootVersion)
                "io.spring.dependency-management" -> useVersion(springDependencyManagementVersion)
                "org.jlleitschuh.gradle.ktlint" -> useVersion(ktLinter)
            }
        }
    }
}