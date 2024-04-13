package me.jimmy.hellospring.consumer.config

import org.apache.kafka.clients.consumer.ConsumerConfig.*
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

@Configuration
@ConditionalOnProperty(
    name = ["kafka.consumer.enabled"],
    havingValue = "true"
)
@EnableKafka
class ConsumerConfig(
    @Value("\${kafka.consumer.bootstrapServer}") private val bootstrapServer: String,
    @Value("\${kafka.consumer.groupId}") private val groupId: String
) {
    @Bean
    fun consumerFactory(): DefaultKafkaConsumerFactory<String, Any> {
        val kafkaProps: MutableMap<String, Any> = HashMap()

        kafkaProps[BOOTSTRAP_SERVERS_CONFIG] = bootstrapServer
        kafkaProps[KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        kafkaProps[VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        kafkaProps[GROUP_ID_CONFIG] = groupId
        return DefaultKafkaConsumerFactory(kafkaProps)
    }
}