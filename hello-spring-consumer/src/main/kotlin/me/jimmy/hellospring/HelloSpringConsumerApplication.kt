package me.jimmy.hellospring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloSpringConsumerApplication

fun main(args: Array<String>) {
    runApplication<HelloSpringConsumerApplication>(*args)
}
