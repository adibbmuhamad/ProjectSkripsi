package com.example.projectskripsi.ui.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectskripsi.data.model.Student1
import com.example.projectskripsi.data.repository.StudentRepository
import kotlinx.coroutines.launch

class StudentViewModel : ViewModel() {

    private val repository = StudentRepository()

    var student1s = mutableStateListOf<Student1>()
    var isLoading = mutableStateOf(false)
    var errorMessage = mutableStateOf("")

    private val TAG = "StudentViewModel"

    fun getStudents() {
        Log.d(TAG, "getStudents: Starting to fetch students")
        isLoading.value = true
        viewModelScope.launch {
            try {
                val response = repository.getStudents()
                if (response.isSuccessful) {
                    Log.d(TAG, "getStudents: Successfully fetched students")
                    student1s.clear()
                    student1s.addAll(response.body()?.data ?: emptyList())
                } else {
                    errorMessage.value = "Failed to load data"
                    Log.e(TAG, "getStudents: Failed to load data, response code: ${response.code()}")
                }
            } catch (e: Exception) {
                errorMessage.value = "Error: ${e.message}"
                Log.e(TAG, "getStudents: Exception occurred", e)
            } finally {
                isLoading.value = false
                Log.d(TAG, "getStudents: Finished fetching students")
            }
        }
    }
}