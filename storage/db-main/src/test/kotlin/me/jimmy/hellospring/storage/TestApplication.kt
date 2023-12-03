package me.jimmy.hellospring.storage

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["me.jimmy.hellospring"])
@ConfigurationPropertiesScan
class TestApplication

fun main(args: Array<String>) {
    runApplication<TestApplication>(*args)
}