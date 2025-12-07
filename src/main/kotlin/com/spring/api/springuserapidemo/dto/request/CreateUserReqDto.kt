package com.spring.api.springuserapidemo.dto.request

import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank

data class CreateUserReqDto(
    @NotBlank(message = "Name cannot be blank")
    val name: String,

    @Valid
    @NotBlank(message = "Email cannot be blank")
    val email: String
)