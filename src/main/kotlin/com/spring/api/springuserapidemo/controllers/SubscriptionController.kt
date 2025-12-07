package com.spring.api.springuserapidemo.controllers

import com.spring.api.springuserapidemo.dto.request.CreateSubscriptionReqDto
import com.spring.api.springuserapidemo.services.SubscriptionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/subscriptions")
class SubscriptionController(private val subscriptionService: SubscriptionService) {
    @PostMapping
    fun createSubscription(@RequestBody createSubscriptionReqDto: CreateSubscriptionReqDto): ResponseEntity<String> {
        return subscriptionService.createSubscription(createSubscriptionReqDto)
    }
}