package me.jimmy.hellospring.controller

import me.jimmy.hellospring.clients.adminapi.AdminApi
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
internal class FeignTestController(
    private val adminApi: AdminApi,
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/feign/{count}")
    fun feignTest(@PathVariable count: Int): HttpStatus {
        logger.info("FeignControllerTest#feignTest start count : $count")
        adminApi.test()
        return HttpStatus.OK
    }
}