package com.spring.api.springuserapidemo.repositories

import com.spring.api.springuserapidemo.models.Subscription
import org.springframework.data.jpa.repository.JpaRepository

interface SubscriptionRepository: JpaRepository<Subscription, Long> 