package com.myfitnessbag.order.core.util.error


data class ErrorModel(
    val message: String? = null,
    val statusCode: Int? = null,
    val cause: Exception? = null,
    val type: AppError,
) : AppError

class ErrorModelBuilder(
    private val type: AppError,
) {
    var message: String? = null
    var statusCode: Int? = null
    var cause: Exception? = null

    fun build(): ErrorModel {
        return ErrorModel(
            message = message,
            statusCode = statusCode,
            cause = cause,
            type = type
        )
    }
}

fun errorModel(
    type: AppError,
    action: ErrorModelBuilder.() -> Unit = {},
): ErrorModel {
    val errorModel = ErrorModelBuilder(type).apply(action).build()
    return errorModel
}

sealed class AppException(
    val error: ErrorModel,
) : Exception(error.message) {


    class LocalException(
        error: ErrorModel,
    ) : AppException(error)

    class CommonException(
        error: ErrorModel,
    ) : AppException(error)
}


