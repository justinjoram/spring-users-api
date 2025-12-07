package com.spring.api.springuserapidemo.mappers

import com.spring.api.springuserapidemo.dto.response.PaginatedResponse
import org.springframework.data.domain.Page

fun <T : Any> Page<T>.toPaginatedResponse(contentMapper: (List<T>) -> List<Any>): PaginatedResponse {
    return PaginatedResponse(contentMapper(this.content), this.totalPages, this.totalElements.toInt())
}