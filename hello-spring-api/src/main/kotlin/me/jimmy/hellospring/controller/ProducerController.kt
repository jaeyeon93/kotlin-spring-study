package me.jimmy.hellospring.controller

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProducerController(
    @Value("\${kafka.producer.topic}") val topic: String,
    private val kafkaTemplate: KafkaTemplate<String, String>,
) {
    private val log = LoggerFactory.getLogger(ProducerController::class.java)

    @GetMapping("/producers/{count}")
    fun produce(
        @PathVariable count: Int,
    ) {
        log.info("count : $count")

        for (i in 1..count) {
            kafkaTemplate.send(
                topic,
                "data$i",
            )
        }
    }
}
