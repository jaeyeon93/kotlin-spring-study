package me.jimmy.hellospring.consumer

import org.apache.commons.logging.LogFactory
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class TestTopicConsumer {

    @KafkaListener(
        topics = ["\${kafka.consumer.topic}"],
        containerFactory = "consumerFactory",
    )
    fun consume(record: ConsumerRecord<String, String>) {
        log.info("header : ${record.headers()} offset : ${record.offset()} value : ${record.value()}")
    }

    private val log = LogFactory.getLog(TestTopicConsumer::class.java)
}