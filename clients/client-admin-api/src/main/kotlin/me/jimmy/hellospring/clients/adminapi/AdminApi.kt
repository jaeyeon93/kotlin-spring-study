package me.jimmy.hellospring.clients.adminapi

import me.jimmy.hellospring.clients.adminapi.response.AdminUserResponse
import me.jimmy.hellospring.clients.adminapi.support.AdminApiResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(url = "\${admin-api.url}", name = "\${admin-api.name}", contextId = "\${admin-api.name}")
interface AdminApi {
    @GetMapping("/admin/test")
    fun userTest(): AdminApiResponse<AdminUserResponse>

    @GetMapping("/admin/tracing-test")
    fun test(): String
}
