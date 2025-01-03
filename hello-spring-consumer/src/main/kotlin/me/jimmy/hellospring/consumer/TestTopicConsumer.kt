package me.jimmy.hellospring.consumer

import me.jimmy.hellospring.clients.adminapi.AdminApi
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class TestTopicConsumer(
    private val adminApi: AdminApi,
) {
    @KafkaListener(
        topics = ["\${kafka.consumer.topic}"],
        containerFactory = "concurrentKafkaListenerContainerFactory",
    )
    fun consume(
        record: ConsumerRecord<String, String>
    ) {
        log.info("header : ${record.headers()} offset : ${record.offset()} value : ${record.value()}")

//        adminApi.test()
        log.info("adminApi#test called")
    }

    private val log = LoggerFactory.getLogger(TestTopicConsumer::class.java)
}
