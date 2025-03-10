package com.example.projectskripsi.ui.screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectskripsi.data.model.StudentDetail
import com.example.projectskripsi.data.repository.StudentRepository
import kotlinx.coroutines.launch

class StudentDetailViewModel : ViewModel() {

    private val repository = StudentRepository()

    var selectedStudent = mutableStateOf<StudentDetail?>(null)
    var isLoading = mutableStateOf(false)
    var errorMessage = mutableStateOf("")

    private val TAG = "StudentDetailViewModel"

    fun getStudentDetail(id: Int) {
        Log.d(TAG, "getStudentDetail: Fetching detail for student ID $id")
        isLoading.value = true
        viewModelScope.launch {
            try {
                val response = repository.getStudentDetail(id)
                if (response.isSuccessful) {
                    selectedStudent.value = response.body()?.data
                    Log.d(TAG, "getStudentDetail: Successfully fetched detail for student ID $id")
                } else {
                    errorMessage.value = "Failed to load detail"
                    Log.e(TAG, "getStudentDetail: Failed to load detail, response code: ${response.code()}")
                }
            } catch (e: Exception) {
                errorMessage.value = "Error: ${e.message}"
                Log.e(TAG, "getStudentDetail: Exception occurred", e)
            } finally {
                isLoading.value = false
                Log.d(TAG, "getStudentDetail: Finished fetching detail for student ID $id")
            }
        }
    }
}