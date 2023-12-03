package me.jimmy.hellospring.domain.user

import org.springframework.stereotype.Component

@Component
class UserWriter(
    private val repository: UserRepository
) {
    fun add(name: String): Long {
        return repository.add(name)
    }
}