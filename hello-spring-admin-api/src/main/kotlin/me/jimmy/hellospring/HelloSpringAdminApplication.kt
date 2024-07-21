package me.jimmy.hellospring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloSpringAdminApplication

fun main(args: Array<String>) {
    runApplication<HelloSpringAdminApplication>(*args)
}
