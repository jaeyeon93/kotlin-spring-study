package me.jimmy.hellospring.consumer.support

import me.jimmy.hellospring.common.util.JsonUtils
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.header.internals.RecordHeaders
import org.apache.kafka.common.record.TimestampType

internal object KafkaTestHelper {
    fun readFileBy(fileName: String) = this.javaClass.classLoader.getResource(fileName).readText()

    fun buildConsumerRecord(body: String): ConsumerRecord<String, String> {
        return buildConsumerRecord("{}", body)
    }

    fun buildConsumerRecord(
        header: String,
        body: String,
    ): ConsumerRecord<String, String> {
        val headers = RecordHeaders()
        JsonUtils.toObject(header, Map::class.java)
            .forEach {
                headers.add(it.key.toString(), it.value.toString().toByteArray())
            }
        return ConsumerRecord("test", 0, 0, 1L, TimestampType.NO_TIMESTAMP_TYPE, 1, 1, "key", body, headers, null)
    }
}
