package com.example.projectskripsi.data.network

import com.example.projectskripsi.data.model.AnnouncementDetailResponse
import com.example.projectskripsi.data.model.AnnouncementResponse
import com.example.projectskripsi.data.model.ClassRoomsResponse
import com.example.projectskripsi.data.model.Student1DetailResponse
import com.example.projectskripsi.data.model.StudentResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    // Mendapatkan daftar pengumuman
    @GET("api/announcements")
    suspend fun getAnnouncements(): Response<AnnouncementResponse>

    // Mendapatkan detail pengumuman berdasarkan ID
    @GET("api/announcements/{id}")
    suspend fun getAnnouncementDetail(@Path("id") id: Int): Response<AnnouncementDetailResponse>

    @GET("api/students")
    suspend fun getStudents(): Response<StudentResponse>

    @GET("api/students/{id}")
    suspend fun getStudentDetail(@Path("id") id: Int): Response<Student1DetailResponse>

    @GET("api/classrooms")
    suspend fun getClassRooms(): Response<ClassRoomsResponse>
}