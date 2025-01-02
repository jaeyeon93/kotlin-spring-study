package me.jimmy.hellospring.consumer

import me.jimmy.hellospring.ConsumerIT
import me.jimmy.hellospring.consumer.support.KafkaTestHelper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class TestTopicConsumerIT(
    private val sut: TestTopicConsumer,
) : ConsumerIT() {
    @Test
    fun `consume 할 수 있다`() {
        val header = KafkaTestHelper.readFileBy("test-header.json")
        val payload = KafkaTestHelper.readFileBy("test-payload.json")
        val record = KafkaTestHelper.buildConsumerRecord(header, payload)

        assertDoesNotThrow {
            sut.consume(record)
        }
    }
}