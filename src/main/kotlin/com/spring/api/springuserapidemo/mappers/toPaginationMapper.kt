package com.spring.api.springuserapidemo.mappers

import com.spring.api.springuserapidemo.utils.PaginatedResponse
import org.springframework.data.domain.Page

fun <T : Any> Page<T>.toPaginatedResponse(contentMapper: (List<T>) -> List<Any>): PaginatedResponse {
    return PaginatedResponse(message = "Data successfully retrieved", contentMapper(this.content), this.totalPages, this.totalElements.toInt())
}