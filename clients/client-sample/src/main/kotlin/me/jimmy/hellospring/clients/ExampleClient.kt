package me.jimmy.hellospring.clients

import org.springframework.cloud.openfeign.FeignClient

@FeignClient(value = "\${example-client.url}", name = "example-client")
interface ExampleClient
