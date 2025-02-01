package me.jimmy.hellospring.clients.adminapi

import com.github.tomakehurst.wiremock.client.WireMock.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock
import org.springframework.test.context.TestConstructor

@SpringBootTest(properties = ["admin-api.url=localhost:9999"])
@AutoConfigureWireMock(port = 9999)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
internal class AdminApiRetryerApiMockTest(
    private val sut: AdminApi,
) {
    @Test
    fun `verify retry`() {
        val requestPath = "/admin/tracing-test"
        stubFor(
            get(urlEqualTo(requestPath))
                .willReturn(serverError())
        )

        val exception = assertThrows<RuntimeException> {
            sut.test()
        }

        verify(3, getRequestedFor(urlEqualTo(requestPath)))

        println(exception.message)
    }
}