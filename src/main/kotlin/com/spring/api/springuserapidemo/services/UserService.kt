package com.spring.api.springuserapidemo.services

import com.spring.api.springuserapidemo.dto.response.UserListResponseDto
import com.spring.api.springuserapidemo.dto.request.CreateUserReqDto
import com.spring.api.springuserapidemo.dto.response.PaginatedResponse
import com.spring.api.springuserapidemo.utils.dto.SearchDto
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface UserService {
    fun createUser(createUserReqDto: CreateUserReqDto): ResponseEntity<String>
    fun getAllUsers(pageable: Pageable, searchDto: SearchDto): ResponseEntity<PaginatedResponse>
    fun getUserById(id: Long): ResponseEntity<UserListResponseDto>
    fun updateUser(id: Long, createUserReqDto: CreateUserReqDto): ResponseEntity<String>
    fun deleteUser(id: Long): ResponseEntity<String>
}