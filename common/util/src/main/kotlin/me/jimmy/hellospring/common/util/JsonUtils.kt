package me.jimmy.hellospring.common.util

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

object JsonUtils {
    private val objectMapper =
        jacksonObjectMapper().also {
            it.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            it.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            it.setSerializationInclusion(JsonInclude.Include.NON_NULL)
            it.registerModule(JavaTimeModule())
            it.registerKotlinModule()
        }

    fun <T> toObject(
        json: String,
        clazz: Class<T>,
    ): T {
        return objectMapper.readValue(json, clazz)
    }
}
