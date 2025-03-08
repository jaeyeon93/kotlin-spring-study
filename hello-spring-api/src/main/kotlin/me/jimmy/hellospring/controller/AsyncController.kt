package me.jimmy.hellospring.controller

import me.jimmy.hellospring.clients.adminapi.AdminApi
import org.slf4j.LoggerFactory
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.Future

@RestController
internal class AsyncController(
    private val coreApiTaskExecutor: ThreadPoolTaskExecutor,
    private val adminApi: AdminApi,
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/async-test/{count}")
    private fun asyncTest(
        @PathVariable count: Int,
    ): String {
        logger.info("AsyncController#asyncTest start")
        val futures = mutableListOf<Future<String>>()
        for (i in 1..count) {
            futures.add(coreApiTaskExecutor.submit<String> { adminApi.test() })
        }
        futures.forEach { it.get() }
        logger.info("AsyncController#asyncTest end")
        return "OK"
    }

    @GetMapping("/sync-test/{count}")
    private fun syncTest(
        @PathVariable count: Int,
    ): String {
        logger.info("AsyncController#syncTest start")
        for (i in 1..count) {
            adminApi.test()
        }
        logger.info("AsyncController#syncTest end")
        return "OK"
    }
}
