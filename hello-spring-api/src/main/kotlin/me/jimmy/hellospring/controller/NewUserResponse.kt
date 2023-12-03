package me.jimmy.hellospring.controller

import me.jimmy.hellospring.domain.user.User

data class NewUserResponse(
    val id: Long
) {
    constructor(user: User): this(user.id)
}
