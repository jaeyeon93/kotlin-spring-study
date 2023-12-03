package me.jimmy.hellospring.storage.db.main

import me.jimmy.helloworld.UserEntityBuilder
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

@CoreDbContextTest
internal class UserJpaRepositoryTest(
    @Autowired private val sut: UserJpaRepository
) {
    @Test
    fun save() {
        sut.save(UserEntityBuilder().build())

    }
}