package me.jimmy.hellospring.consumer.config

import org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG
import org.apache.kafka.clients.consumer.ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG
import org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG
import org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG
import org.apache.kafka.clients.consumer.ConsumerConfig.MAX_POLL_RECORDS_CONFIG
import org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ContainerProperties

@Configuration
@ConditionalOnProperty(
    name = ["kafka.consumer.enabled"],
    havingValue = "true",
)
@EnableKafka
class ConsumerConfig(
    @Value("\${kafka.consumer.bootstrapServer}") private val bootstrapServer: String,
    @Value("\${kafka.consumer.groupId}") private val groupId: String,
    @Value("\${kafka.consumer.max-poll-records}") private val maxPollRecords: Int,
    @Value("\${kafka.consumer.enableAutoCommit:false}") private val enableAutoCommit: Boolean,
) {
    @Bean
    fun consumerFactory(): DefaultKafkaConsumerFactory<String, Any> {
        val kafkaProps: MutableMap<String, Any> = HashMap()
        kafkaProps[BOOTSTRAP_SERVERS_CONFIG] = bootstrapServer
        kafkaProps[KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        kafkaProps[VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        kafkaProps[GROUP_ID_CONFIG] = groupId
        kafkaProps[MAX_POLL_RECORDS_CONFIG] = maxPollRecords
        kafkaProps[ENABLE_AUTO_COMMIT_CONFIG] = enableAutoCommit
        return DefaultKafkaConsumerFactory(kafkaProps)
    }

    @Bean
    fun concurrentKafkaListenerContainerFactory(
        consumerFactory: ConsumerFactory<String, Any>,
    ): ConcurrentKafkaListenerContainerFactory<String, Any> {
        return (ConcurrentKafkaListenerContainerFactory<String, Any>()).also {
            it.consumerFactory = consumerFactory
            it.containerProperties.ackMode = ContainerProperties.AckMode.MANUAL
        }
    }
}
