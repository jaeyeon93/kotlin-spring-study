package me.jimmy.hellpspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HellpSpringApplication

fun main(args: Array<String>) {
    runApplication<HellpSpringApplication>(*args)
}
