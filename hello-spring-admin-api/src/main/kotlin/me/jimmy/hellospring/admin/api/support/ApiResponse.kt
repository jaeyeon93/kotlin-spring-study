package me.jimmy.hellospring.admin.api.support

internal data class ApiResponse<T>(
    val result: String,
    val data: T?,
    val error: Any?,
) {
    companion object {
        fun <T> success(data: T): ApiResponse<T> {
            return ApiResponse(
                result = "SUCCESS",
                data = data,
                error = null,
            )
        }
    }
}
