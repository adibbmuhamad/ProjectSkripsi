package com.example.projectskripsi.data.model

data class ClassRoomsResponse(
    val success: Boolean,
    val data: List<ClassRoom>,
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