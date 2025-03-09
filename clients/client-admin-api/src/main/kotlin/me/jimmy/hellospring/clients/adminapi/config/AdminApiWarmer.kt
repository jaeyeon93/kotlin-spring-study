package me.jimmy.hellospring.clients.adminapi.config

import com.fasterxml.jackson.databind.ObjectMapper
import me.jimmy.hellospring.clients.adminapi.response.AdminUserResponse
import me.jimmy.hellospring.clients.adminapi.support.AdminApiResponse
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Component

@Component
internal class AdminApiWarmer(
    private val objectMapper: ObjectMapper,
) : InitializingBean {

    override fun afterPropertiesSet() {
        warmUpResponse(objectMapper)
    }

    private fun warmUpResponse(objectMapper: ObjectMapper) {
        listOf(
            AdminApiResponse::class.java,
            AdminUserResponse::class.java
        ).forEach {
            val javaType = objectMapper.constructType(it)
            objectMapper.canDeserialize(javaType)
        }
    }
}