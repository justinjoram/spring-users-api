package com.spring.api.springuserapidemo.services

import com.spring.api.springuserapidemo.dto.request.CreateSubscriptionReqDto
import org.springframework.http.ResponseEntity

interface SubscriptionService {
    fun createSubscription(createSubscriptionReqDto: CreateSubscriptionReqDto): ResponseEntity<String>
}