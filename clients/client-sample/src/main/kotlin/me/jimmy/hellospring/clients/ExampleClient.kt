package me.jimmy.hellospring.clients

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(url = "\${example-client.url}", name = "example-client")
interface ExampleClient {
    @GetMapping(
        value = ["/users/{userId}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun getUserById(
        @PathVariable userId: Long,
    ): UserResponseDto
}
