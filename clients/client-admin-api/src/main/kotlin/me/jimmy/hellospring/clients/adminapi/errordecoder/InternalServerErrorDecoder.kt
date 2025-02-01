package me.jimmy.hellospring.clients.adminapi.errordecoder

import feign.FeignException
import feign.Response
import feign.RetryableException
import feign.codec.ErrorDecoder
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import java.lang.Exception

internal class InternalServerErrorDecoder : ErrorDecoder {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun decode(methodKey: String, response: Response): Exception {
        val exception = FeignException.errorStatus(methodKey, response)
        if (response.status() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            logger.info("admin api 500 에러", exception)

            return RetryableException(
                response.status(),
                exception.message,
                response.request().httpMethod(),
                1000L,
                response.request()
            )
        }
        return exception
    }
}