package com.example.projectskripsi.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Class
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.projectskripsi.data.model.ClassRoom

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClassRoomsPage(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: ClassRoomsViewModel = viewModel()
) {
    val classRooms by viewModel.classRooms.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Class Rooms") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(classRooms) { classRoom ->
                    ClassRoomItem(classRoom) {
                        // Handle item click, e.g., navigate to detail page
                    }
                }
            }
        }
    }
}

@Composable
fun ClassRoomItem(classRoom: ClassRoom, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Class,
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = classRoom.name,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Room Number: ${classRoom.room_number}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Capacity: ${classRoom.capacity}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Class Teacher: ${classRoom.class_teacher}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}