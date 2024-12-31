package me.jimmy.hellospring.clients.adminapi

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(url = "\${admin-api.url}", name = "\${admin-api.name}")
interface AdminApi {
    @GetMapping("/admin/tracing-test")
    fun test(): HttpStatus
}