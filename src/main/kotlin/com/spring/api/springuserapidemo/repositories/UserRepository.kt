package com.spring.api.springuserapidemo.repositories

import com.spring.api.springuserapidemo.models.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE (:search IS NULL OR u.name LIKE %:search% OR u.email LIKE %:search%)")
    fun findAllPageable(pageable: Pageable, search: String?): Page<User>
}