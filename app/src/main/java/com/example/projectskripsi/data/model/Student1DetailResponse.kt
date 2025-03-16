package com.example.projectskripsi.data.model

import com.google.gson.annotations.SerializedName

data class StudentDetailResponse(
    @SerializedName("data")
    val data: Student1Detail
)

data class Student1Detail(
    val id: Int,
    val name: String,//
    val parent_email: String,//
    val nisn: String,//
    val address: String,//
    val created_at: String,
    val updated_at: String,
    val class_room_id: Int,//
    val class_room_name: String,
    val gender: String,//
    val parent_name: String,//
    val phone_number: String//
)