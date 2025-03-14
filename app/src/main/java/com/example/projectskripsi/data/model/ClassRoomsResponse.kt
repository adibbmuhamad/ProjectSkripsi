package com.example.projectskripsi.data.model

data class ClassRoomsResponse(
    val success: Boolean,
    val data: List<ClassRoom>,
    val meta: Meta,
    val links: Links
)

data class ClassRoom(
    val id: Int,
    val name: String,
    val createdAt: String,
    val updatedAt: String,
    val room_number: String,
    val capacity: Int,
    val class_teacher: String
)

data class Meta(
    val currentPage: Int,
    val from: Int,
    val lastPage: Int,
    val perPage: Int,
    val to: Int,
    val total: Int
)

data class Links(
    val prev: String?,
    val next: String?
)