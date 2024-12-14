package me.jimmy.hellospring.admin.api

import me.jimmy.hellospring.clients.ExampleClient
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
class AdminController(
    private val exampleClient: ExampleClient,
) {
    @GetMapping("/test")
    fun test(): HttpStatus {
        val user = exampleClient.getUserById(0L)
        log.info("user : $user")
        return HttpStatus.OK
    }

    @GetMapping("/tracing-test")
    fun tracingTest(): HttpStatus {
        log.info("tracingTest start")
        return HttpStatus.OK
    }

    companion object {
        private val log = LoggerFactory.getLogger(AdminController::class.java)
    }
}
