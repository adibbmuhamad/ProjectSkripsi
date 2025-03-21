package com.example.projectskripsi.data.model

data class StudentResponse(
    val data: List<Student1>,
    val links: Links,
    val meta: Meta
)

data class Student1(
    val id: Int,
    val name: String,
    val parent_email: String,
    val nisn: String,
    val address: String,
    val created_at: String,
    val updated_at: String,
    val class_room_id: Int,
    val class_room_name: String,
    val gender: String,
    val parent_name: String,
    val phone_number: String
)

data class Links(
    val first: String,
    val last: String,
    val prev: String?,
    val next: String?
)

data class Meta(
    val currentPage: Int,
    val from: Int,
    val lastPage: Int,
    val links: List<PageLink>,
    val path: String,
    val perPage: Int,
    val to: Int,
    val total: Int
)

data class PageLink(
    val url: String?,
    val label: String,
    val active: Boolean
)