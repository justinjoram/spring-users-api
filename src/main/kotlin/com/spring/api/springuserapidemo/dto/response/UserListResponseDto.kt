package com.spring.api.springuserapidemo.dto.response

import java.time.LocalDateTime

data class UserListResponseDto(val id: Long, var name: String, var email: String, val createdAt: LocalDateTime)