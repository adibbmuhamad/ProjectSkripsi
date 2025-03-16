package com.example.projectskripsi.data.repository

import android.util.Log
import com.example.projectskripsi.data.model.Student1DetailResponse
import com.example.projectskripsi.data.model.StudentResponse
import com.example.projectskripsi.data.network.RetrofitClient
import retrofit2.Response

class StudentRepository {

    private val TAG = "StudentRepository"

    suspend fun getStudents(): Response<StudentResponse> {
        Log.d(TAG, "getStudents: Fetching student list from API")
        val response = RetrofitClient.apiService.getStudents()
        if (response.isSuccessful) {
            Log.d(TAG, "getStudents: Successfully fetched student list")
        } else {
            Log.e(TAG, "getStudents: Failed to fetch student list, response code: ${response.code()}")
        }
        return response
    }

    suspend fun getStudentDetail(id: Int): Response<Student1DetailResponse> {
        Log.d(TAG, "getStudentDetail: Fetching student detail for ID $id from API")
        val response = RetrofitClient.apiService.getStudentDetail(id)
        if (response.isSuccessful) {
            Log.d(TAG, "getStudentDetail: Successfully fetched student detail for ID $id")
        } else {
            Log.e(TAG, "getStudentDetail: Failed to fetch student detail for ID $id, response code: ${response.code()}")
        }
        return response
    }
}