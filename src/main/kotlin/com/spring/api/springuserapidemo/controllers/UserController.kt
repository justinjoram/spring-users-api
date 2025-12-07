package com.spring.api.springuserapidemo.controllers

import com.spring.api.springuserapidemo.dto.request.CreateUserReqDto
import com.spring.api.springuserapidemo.services.UserService
import com.spring.api.springuserapidemo.utils.PaginatedResponse
import com.spring.api.springuserapidemo.utils.Response
import com.spring.api.springuserapidemo.utils.dto.SearchDto
import jakarta.validation.Valid
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/users")
class UserController(private val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody @Valid createUserReqDto: CreateUserReqDto): ResponseEntity<Response> {
        return userService.createUser(createUserReqDto)
    }

    @GetMapping
    fun getAllUsers(pageable: Pageable, @ModelAttribute searchDto: SearchDto): ResponseEntity<PaginatedResponse> {
        return userService.getAllUsers(pageable, searchDto)
    }

    @GetMapping("{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<Response> {
        return userService.getUserById(id)
    }

    @PutMapping("{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody createUserReqDto: CreateUserReqDto): ResponseEntity<String> {
        return userService.updateUser(id, createUserReqDto)
    }

    @DeleteMapping("{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<String> {
        return userService.deleteUser(id)
    }
}