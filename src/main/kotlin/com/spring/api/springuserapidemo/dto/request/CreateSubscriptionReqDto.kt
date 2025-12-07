package com.spring.api.springuserapidemo.dto.request

import com.spring.api.springuserapidemo.enums.SubscriptionEnum

data class CreateSubscriptionReqDto(
    val name: String,
    val status: SubscriptionEnum,
    val userId: Long
)