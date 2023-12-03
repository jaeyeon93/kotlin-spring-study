package me.jimmy.hellospring.storage.db.main

import org.junit.jupiter.api.Tag
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor


@ActiveProfiles("local")
@Tag("context")
@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
annotation class CoreDbContextTest