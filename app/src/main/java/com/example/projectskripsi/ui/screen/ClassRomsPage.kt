package com.example.projectskripsi.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.projectskripsi.data.model.ClassRoom

@Composable
fun ClassRomsPage(navController: NavController, modifier: Modifier = Modifier, viewModel: ClassRoomsViewModel = viewModel()) {
    val classRooms by viewModel.classRooms.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        classRooms.forEach { classRoom ->
            ClassRoomItem(classRoom)
            Divider()
        }
    }
}

@Composable
fun ClassRoomItem(classRoom: ClassRoom) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(text = "Name: ${classRoom.name}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Room Number: ${classRoom.room_number}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Capacity: ${classRoom.capacity}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Class Teacher: ${classRoom.class_teacher}", style = MaterialTheme.typography.bodyMedium)
    }
}