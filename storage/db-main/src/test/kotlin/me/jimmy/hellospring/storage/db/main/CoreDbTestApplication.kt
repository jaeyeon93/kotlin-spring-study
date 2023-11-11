package me.jimmy.hellospring.storage.db.main

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class CoreDbTestApplication

fun main(args: Array<String>) {
    runApplication<CoreDbTestApplication>(*args)
}