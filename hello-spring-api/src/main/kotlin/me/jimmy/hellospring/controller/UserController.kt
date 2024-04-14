package me.jimmy.hellospring.controller

import me.jimmy.hellospring.domain.user.User
import me.jimmy.hellospring.domain.user.UserService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService,
) {
    @PostMapping("/users")
    fun addUser(
        @RequestBody request: NewUserRequest,
    ): NewUserResponse {
        return NewUserResponse(userService.add(request.name))
    }

    @GetMapping("/users/{userId}")
    fun findUser(
        @PathVariable userId: Long,
    ): UserResponse {
        log.info("userId : $userId")
        if (userId == 0L) {
            return UserResponse(User(id = userId, name = "test"))
        }
        return UserResponse(userService.read(userId))
    }

    @GetMapping("/thread")
    fun threadTest(): String {
        println("[여기]threadName : ${Thread.currentThread().name}")
        Thread.sleep(100000L)
        return "OK"
    }

    companion object {
        private val log = LoggerFactory.getLogger(UserController::class.java)
    }
}
