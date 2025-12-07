package com.spring.api.springuserapidemo.utils

class PaginatedResponse(
    val message: String = "Data successfully retrieved",
    val data: List<Any>,
    val currentPage: Int,
    val pageSize: Int
)