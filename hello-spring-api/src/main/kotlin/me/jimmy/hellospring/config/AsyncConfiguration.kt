package me.jimmy.hellospring.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.TaskDecorator
import org.springframework.core.task.support.CompositeTaskDecorator
import org.springframework.core.task.support.ContextPropagatingTaskDecorator
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

@Configuration
@EnableAsync
internal class AsyncConfiguration {
    @Bean
    fun coreApiTaskExecutor(): ThreadPoolTaskExecutor {
        return ThreadPoolTaskExecutor().initExecutor(
            corePoolSize = 30,
            maxPoolSize = 30,
            threadNamePrefix = "core-api-async",
            taskDecorator =
                CompositeTaskDecorator(
                    listOf(
                        ContextPropagatingTaskDecorator(),
                        MdcDecorator(),
                    ),
                ),
        )
    }

    private fun ThreadPoolTaskExecutor.initExecutor(
        corePoolSize: Int,
        maxPoolSize: Int,
        threadNamePrefix: String,
        awaitTerminationSeconds: Int = 3,
        waitForJobToCompleteOnShutDown: Boolean = true,
        taskDecorator: TaskDecorator,
    ): ThreadPoolTaskExecutor {
        return apply {
            setCorePoolSize(corePoolSize)
            setMaxPoolSize(maxPoolSize)
            setThreadNamePrefix(threadNamePrefix)
            setAwaitTerminationSeconds(awaitTerminationSeconds)
            setWaitForTasksToCompleteOnShutdown(waitForJobToCompleteOnShutDown)
            setTaskDecorator(taskDecorator)
        }
    }
}
