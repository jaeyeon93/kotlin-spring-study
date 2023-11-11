package me.jimmy.helloworld

import me.jimmy.hellospring.storage.db.main.UserEntity

data class UserEntityBuilder(
    val name: String = "testName"
) {
    fun build() = UserEntity(
        name = name
    )
}
