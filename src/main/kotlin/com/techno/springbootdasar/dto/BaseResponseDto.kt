package com.techno.springbootdasar.dto

data class BaseResponseDto<T>(
    val status: String? = null,
    val message: String? = null,
    val result: T? = null

)
