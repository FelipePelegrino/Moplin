package com.gmail.devpelegrino.moplim.network.entity

data class ReviewListEntity(
    val results: List<ItemReview>
)

data class ItemReview(
    val author: String?,
    val content: String?
)