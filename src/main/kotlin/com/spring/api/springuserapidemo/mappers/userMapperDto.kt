package com.spring.api.springuserapidemo.mappers

import com.spring.api.springuserapidemo.dto.response.UserListResponseDto
import com.spring.api.springuserapidemo.models.User

fun User.toUserDto(): UserListResponseDto {
    return UserListResponseDto(this.id!!, this.name, this.email, this.createdAt)
}