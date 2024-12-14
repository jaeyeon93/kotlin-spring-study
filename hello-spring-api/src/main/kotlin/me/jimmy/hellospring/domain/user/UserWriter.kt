package me.jimmy.hellospring.domain.user

import me.jimmy.hellospring.storage.db.main.UserEntity
import me.jimmy.hellospring.storage.db.main.UserJpaRepository
import org.springframework.stereotype.Component

@Component
class UserWriter(
    private val userJpaRepository: UserJpaRepository,
) {
    fun add(name: String): Long {
        return userJpaRepository.save(
            UserEntity(
                name = name,
            ),
        ).id!!
    }
}
