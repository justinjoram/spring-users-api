package com.spring.api.springuserapidemo.models

import com.spring.api.springuserapidemo.utils.BaseModel
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @Column(name = "name",unique = true)
    var name: String,

    @Column(name = "email",unique = true)
    var email: String
): BaseModel()
