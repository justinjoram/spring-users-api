package com.spring.api.springuserapidemo.utils

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PrePersist
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseModel {
    @Column(name = "created_at", nullable = false, updatable = false)
    lateinit var createdAt: LocalDateTime

    @Column(name = "updated_at", nullable = false, updatable = true)
    lateinit var updatedAt: LocalDateTime

    @PrePersist
    fun onCreate() {
        createdAt = LocalDateTime.now()
        updatedAt = createdAt
    }
}

