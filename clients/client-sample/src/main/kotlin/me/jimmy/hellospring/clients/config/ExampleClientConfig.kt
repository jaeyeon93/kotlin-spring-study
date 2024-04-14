package me.jimmy.hellospring.clients.config

import feign.Logger
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@EnableFeignClients(basePackages = ["me.jimmy.hellospring"])
@Configuration
class ExampleClientConfig {
    @Bean
    fun feignLoggerLevel(): Logger.Level {
        return Logger.Level.FULL
    }
}
