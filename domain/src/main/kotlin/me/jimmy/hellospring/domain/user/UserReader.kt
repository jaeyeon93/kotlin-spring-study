package me.jimmy.hellospring.domain.user

import org.springframework.stereotype.Component

@Component
class UserReader(
    private val repository: UserRepository
) {
    fun read(id: Long): User {
        return repository.read(id) ?: throw java.util.NoSuchElementException()
    }
}