package com.spring.api.springuserapidemo.dto.response

data class UserDetailsReqDto(
    val id: Long,
    val name: String,
    val email: String,
    val subscriptions: List<SubscriptionDetailDto>?
)