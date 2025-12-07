package com.spring.api.springuserapidemo.models

import com.spring.api.springuserapidemo.enums.SubscriptionEnum
import com.spring.api.springuserapidemo.utils.BaseModel
import jakarta.persistence.*

@Entity
@Table(name = "subscriptions")
data class Subscription(
    @Column(name = "name", nullable = false)
    val name: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    val status: SubscriptionEnum,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,
): BaseModel()