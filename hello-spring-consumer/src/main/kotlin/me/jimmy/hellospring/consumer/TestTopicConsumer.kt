package me.jimmy.hellospring.consumer

import org.apache.commons.logging.LogFactory
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component

@Component
class TestTopicConsumer {

    @KafkaListener(
        topics = ["\${kafka.consumer.topic}"],
        containerFactory = "kafkaListenerContainerFactory",
    )
    fun consume(record: ConsumerRecord<String, String>, acknowledgment: Acknowledgment) {
        log.info("header : ${record.headers()} offset : ${record.offset()} value : ${record.value()}")

        Thread.sleep(10000)
        acknowledgment.acknowledge()
    }

    private val log = LogFactory.getLog(TestTopicConsumer::class.java)
}