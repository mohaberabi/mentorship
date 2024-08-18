package com.myfitnessbag.order.core.util.error


interface AppError


enum class LocalError : AppError {
    DISK_FULL,
    UNKNOWN,
    IO
}

enum class CommonError : AppError {
    IO_ERROR,
    UNKNOWN,
}


