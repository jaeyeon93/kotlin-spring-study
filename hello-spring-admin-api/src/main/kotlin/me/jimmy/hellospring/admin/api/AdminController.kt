package me.jimmy.hellospring.admin.api

import me.jimmy.hellospring.admin.api.response.AdminUserResponse
import me.jimmy.hellospring.admin.api.support.ApiResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
internal class AdminController {
    @GetMapping("/admin/test")
    fun test(): ApiResponse<AdminUserResponse> {
        log.info("admin/test start")
        return ApiResponse.success(
            AdminUserResponse(
                id = 0L,
                name = "test",
            ),
        )
    }

    @GetMapping("/admin/tracing-test")
    fun tracingTest(): String {
        log.info("tracingTest start")
        return HttpStatus.OK.name
    }

    companion object {
        private val log = LoggerFactory.getLogger(AdminController::class.java)
    }
}
