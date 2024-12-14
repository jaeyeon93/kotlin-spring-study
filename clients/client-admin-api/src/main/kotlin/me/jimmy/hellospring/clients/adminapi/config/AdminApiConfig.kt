package me.jimmy.hellospring.clients.adminapi.config

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@EnableFeignClients(basePackages = ["me.jimmy.hellospring"])
@Configuration
internal class AdminApiConfig