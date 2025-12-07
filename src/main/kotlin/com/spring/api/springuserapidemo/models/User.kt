package com.spring.api.springuserapidemo.models

import com.spring.api.springuserapidemo.utils.BaseModel
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Column(name = "name",unique = true)
    var name: String,

    @Column(name = "email",unique = true)
    var email: String,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val subscriptions: List<Subscription>? = null
): BaseModel()
