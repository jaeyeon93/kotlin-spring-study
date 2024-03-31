package me.jimmy.hellospring

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

@SpringBootTest
class ApplicationContextTest(
    private val sut: ApplicationContext,
) {
    @Test
    fun `테스트`() {
        sut.environment
        sut.environment.getProperty("custom.user")
        log.info("test")
    }

    private val log = LoggerFactory.getLogger(ApplicationContextTest::class.java)
}
