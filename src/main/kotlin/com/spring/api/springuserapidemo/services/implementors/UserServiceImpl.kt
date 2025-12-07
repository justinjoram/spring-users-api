package com.spring.api.springuserapidemo.services.implementors

import com.spring.api.springuserapidemo.dto.request.CreateUserReqDto
import com.spring.api.springuserapidemo.dto.response.SubscriptionDetailDto
import com.spring.api.springuserapidemo.dto.response.UserDetailsReqDto
import com.spring.api.springuserapidemo.utils.PaginatedResponse
import com.spring.api.springuserapidemo.models.User
import com.spring.api.springuserapidemo.mappers.toPaginatedResponse
import com.spring.api.springuserapidemo.mappers.toUserDto
import com.spring.api.springuserapidemo.repositories.UserRepository
import com.spring.api.springuserapidemo.services.UserService
import com.spring.api.springuserapidemo.utils.Response
import com.spring.api.springuserapidemo.utils.dto.SearchDto
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {
    override fun createUser(createUserReqDto: CreateUserReqDto): ResponseEntity<Response> {
        userRepository.save(User(createUserReqDto.name, createUserReqDto.email))
        return ResponseEntity.ok(Response("User created"))
    }

    override fun getAllUsers(pageable: Pageable, searchDto: SearchDto): ResponseEntity<PaginatedResponse> {
        val usersPage = userRepository.findAllPageable(pageable, searchDto.search)
        return ResponseEntity.ok(usersPage.toPaginatedResponse { users -> users.map { it.toUserDto() } })
    }

    override fun getUserById(id: Long): ResponseEntity<Response> {
        val user = userRepository.findById(id).orElse(null) ?: return ResponseEntity.notFound().build()
        val subscriptionsDto = user.subscriptions?.map { SubscriptionDetailDto(it.id!!, it.name, it.status.name) }
        return ResponseEntity.ok(Response(message = "User details retrieved", data = UserDetailsReqDto(user.id!!, user.name, user.email, subscriptionsDto)))
    }

    override fun updateUser(id: Long, createUserReqDto: CreateUserReqDto): ResponseEntity<String> {
        val user = userRepository.findById(id).orElse(null) ?: return ResponseEntity.notFound().build()
        user.apply { name = createUserReqDto.name; email = createUserReqDto.email }
        userRepository.save(user)
        return ResponseEntity.ok("User updated")
    }

    override fun deleteUser(id: Long): ResponseEntity<String> {
        val user = userRepository.findById(id).orElse(null) ?: return ResponseEntity.notFound().build()
        userRepository.delete(user)
        return ResponseEntity.ok("User deleted")
    }
}