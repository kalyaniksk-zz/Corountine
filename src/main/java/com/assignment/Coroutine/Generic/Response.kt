package com.assignment.Coroutine.Generic

sealed class Response<T, E>(open val data: T?)

 data class ErrorResponse<T, E> constructor(val errorData: E?, override val data: T? = null) : Response<T, E>(data)
data class SuccessResponse<T, E> constructor(override val data: T) : Response<T, E>(data)