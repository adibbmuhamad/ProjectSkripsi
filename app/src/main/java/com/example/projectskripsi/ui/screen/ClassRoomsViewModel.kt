package com.example.projectskripsi.ui.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectskripsi.data.model.ClassRoom
import com.example.projectskripsi.data.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ClassRoomsViewModel : ViewModel() {

    private val _classRooms = MutableStateFlow<List<ClassRoom>>(emptyList())
    val classRooms: StateFlow<List<ClassRoom>> = _classRooms

    init {
        fetchClassRooms()
    }

    private fun fetchClassRooms() {
        viewModelScope.launch {
            try {
                Log.d("ClassRoomsViewModel", "Fetching class rooms...")
                val response = RetrofitClient.apiService.getClassRooms()
                if (response.isSuccessful) {
                    _classRooms.value = response.body()?.data ?: emptyList()
                    Log.d("ClassRoomsViewModel", "Successfully fetched class rooms: ${_classRooms.value.size} items")
                } else {
                    Log.e("ClassRoomsViewModel", "Failed to fetch class rooms: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("ClassRoomsViewModel", "Exception occurred while fetching class rooms", e)
            }
        }
    }
}