package me.jimmy.hellospring.storage.db.main

import javax.persistence.Column
import javax.persistence.Entity

@Entity
class UserEntity(
    @Column
    val name: String
) : BaseEntity()