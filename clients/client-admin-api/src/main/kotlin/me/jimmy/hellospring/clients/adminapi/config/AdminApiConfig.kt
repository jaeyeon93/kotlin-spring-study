package me.jimmy.hellospring.clients.adminapi.config

import feign.Retryer
import feign.codec.ErrorDecoder
import me.jimmy.hellospring.clients.adminapi.errordecoder.InternalServerErrorDecoder
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@EnableFeignClients(basePackages = ["me.jimmy.hellospring.clients.adminapi"])
@Configuration
internal class AdminApiConfig {
    @Bean
    fun adminApiRetryer(): Retryer {
        return Retryer.Default(1000, 3000, 3)
    }

    @Bean
    fun adminApiErrorDecoder(): ErrorDecoder {
        return InternalServerErrorDecoder()
    }
}
