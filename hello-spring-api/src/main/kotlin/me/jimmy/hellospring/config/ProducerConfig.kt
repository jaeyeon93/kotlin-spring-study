package me.jimmy.hellospring.config

import org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG
import org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG
import org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.ProducerFactory

@Configuration
class ProducerConfig(
    @Value("\${kafka.producer.bootstrapServer}") private val bootstrapServer: String,
) {
    @Bean
    fun producerFactory(): ProducerFactory<Any, Any> {
        val configProps: MutableMap<String, Any> = mutableMapOf()
        configProps[BOOTSTRAP_SERVERS_CONFIG] = bootstrapServer
        configProps[KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        configProps[VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java

        return DefaultKafkaProducerFactory(configProps)
    }
}
