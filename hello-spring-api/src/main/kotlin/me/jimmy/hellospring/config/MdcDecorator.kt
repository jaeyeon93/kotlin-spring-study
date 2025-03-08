package me.jimmy.hellospring.config

import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.core.task.TaskDecorator

internal class MdcDecorator : TaskDecorator {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun decorate(runnable: Runnable): Runnable {
        val contextMap = MDC.getCopyOfContextMap()
        return Runnable {
            try {
                contextMap?.let { MDC.setContextMap(it) }
                runnable.run()
            } catch (e: Exception) {
                logger.warn("비동기 예외발생")
                throw e
            } finally {
                MDC.clear()
            }
        }
    }
}