package com.spring.api.springuserapidemo.services.implementors

import com.spring.api.springuserapidemo.dto.request.CreateSubscriptionReqDto
import com.spring.api.springuserapidemo.enums.SubscriptionEnum
import com.spring.api.springuserapidemo.models.Subscription
import com.spring.api.springuserapidemo.repositories.SubscriptionRepository
import com.spring.api.springuserapidemo.repositories.UserRepository
import com.spring.api.springuserapidemo.services.SubscriptionService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class SubscriptionServiceImpl(
    val subscriptionRepository: SubscriptionRepository,
    val userRepository: UserRepository
): SubscriptionService {
    override fun createSubscription(createSubscriptionReqDto: CreateSubscriptionReqDto): ResponseEntity<String> {
        val user = userRepository.findById(createSubscriptionReqDto.userId).orElse(null) ?: return ResponseEntity.notFound().build()
        val subscription = Subscription(
            user = user,
            name = createSubscriptionReqDto.name,
            status = SubscriptionEnum.ACTIVE,
        )
        subscriptionRepository.save(subscription)
        return ResponseEntity.ok("Subscription created successfully")
    }
}