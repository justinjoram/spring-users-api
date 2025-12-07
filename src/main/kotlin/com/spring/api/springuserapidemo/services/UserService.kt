package com.spring.api.springuserapidemo.services

import com.spring.api.springuserapidemo.dto.request.CreateUserReqDto
import com.spring.api.springuserapidemo.utils.PaginatedResponse
import com.spring.api.springuserapidemo.utils.Response
import com.spring.api.springuserapidemo.utils.dto.SearchDto
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface UserService {
    fun createUser(createUserReqDto: CreateUserReqDto): ResponseEntity<Response>
    fun getAllUsers(pageable: Pageable, searchDto: SearchDto): ResponseEntity<PaginatedResponse>
    fun getUserById(id: Long): ResponseEntity<Response>
    fun updateUser(id: Long, createUserReqDto: CreateUserReqDto): ResponseEntity<String>
    fun deleteUser(id: Long): ResponseEntity<String>
}