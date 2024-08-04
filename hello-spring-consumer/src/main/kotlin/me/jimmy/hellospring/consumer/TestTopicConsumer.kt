package me.jimmy.hellospring.consumer

import me.jimmy.hellospring.clients.ExampleClient
import org.apache.commons.logging.LogFactory
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component

@Component
class TestTopicConsumer(
    private val exampleClient: ExampleClient,
) {
    @KafkaListener(
        topics = ["\${kafka.consumer.topic}"],
        containerFactory = "concurrentKafkaListenerContainerFactory",
    )
    fun consume(record: ConsumerRecord<String, String>, acknowledgment: Acknowledgment) {
        log.info("header : ${record.headers()} offset : ${record.offset()} value : ${record.value()}")

        Thread.sleep(500)
        val user = exampleClient.getUserById(0L)
        log.info("user : $user")

        acknowledgment.acknowledge()
    }

    private val log = LoggerFactory.getLogger(TestTopicConsumer::class.java)
}