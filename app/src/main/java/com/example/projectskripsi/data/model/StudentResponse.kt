package com.example.projectskripsi.data.model

import com.google.gson.annotations.SerializedName

data class StudentResponse(
    val data: List<Student>
)

data class Student(
    val id: Int,
    val name: String,
    @SerializedName("class_room") val classRoom: String,
    @SerializedName("parent_email") val parentEmail: String,
    val nisn: String,
    val address: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String
)