package com.example.projectskripsi.ui.screen

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

    fun getStudentDetail(id: Int) {
        isLoading.value = true
        viewModelScope.launch {
            try {
                val response = repository.getStudentDetail(id)
                if (response.isSuccessful) {
                    selectedStudent.value = response.body()?.data
                } else {
                    errorMessage.value = "Failed to load detail"
                }
            } catch (e: Exception) {
                errorMessage.value = "Error: ${e.message}"
            } finally {
                isLoading.value = false
            }
        }
    }
}