package com.spring.api.springuserapidemo.dto.request

import com.spring.api.springuserapidemo.enums.SubscriptionStatus

data class CreateSubscriptionReqDto(
    val name: String,
    val status: SubscriptionStatus,
    val userId: Long
)