package me.jimmy.hellospring.storage

import javax.persistence.Entity

@Entity
internal class UserEntity(
    val name: String
) : BaseEntity()