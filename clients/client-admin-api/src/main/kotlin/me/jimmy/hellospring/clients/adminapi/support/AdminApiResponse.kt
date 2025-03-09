package me.jimmy.hellospring.clients.adminapi.support

data class AdminApiResponse<T>(
    val result: String,
    val data: T?,
    val error: Any?,
)
