package me.jimmy.hellospring

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.TestConstructor

@SpringBootTest(properties = ["kafka.consumer.enabled=true"])
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ComponentScan(basePackages = ["me.jimmy.hellospring"])
internal class ConsumerIT
