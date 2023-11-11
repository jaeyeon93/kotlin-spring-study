package me.jimmy.hellospring.controller

import me.jimmy.hellospring.domain.user.User

data class UserResponse(
    val name: String
) {
    constructor(user: User) : this(user.name)
}