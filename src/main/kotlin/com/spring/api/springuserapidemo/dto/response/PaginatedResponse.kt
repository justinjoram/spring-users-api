package com.spring.api.springuserapidemo.dto.response

class PaginatedResponse(
    val data: List<Any>,
    val currentPage: Int,
    val pageSize: Int
)