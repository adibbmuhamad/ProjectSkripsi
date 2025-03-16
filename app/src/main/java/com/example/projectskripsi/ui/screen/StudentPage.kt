package com.example.projectskripsi.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.projectskripsi.data.model.Student

@Composable
fun StudentPage(
    navController: NavController,
    viewModel: StudentViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val students = viewModel.students
    val isLoading = viewModel.isLoading.value
    val errorMessage = viewModel.errorMessage.value

    // Memanggil getStudents() ketika StudentPage dimulai
    LaunchedEffect(Unit) {
        viewModel.getStudents()
    }

    Column(modifier = modifier.padding(16.dp)) {
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
        } else {
            LazyColumn {
                items(students) { student ->
                    StudentItem(student) {
                        // Navigate to StudentDetailPage with student.id
                        navController.navigate("student_detail/${student.id}")
                    }
                    Divider(modifier = Modifier.padding(vertical = 8.dp))
                }
            }
        }
    }
}

@Composable
fun StudentItem(student: Student, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = student.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Class Room: ${student.class_room_id}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "NISN: ${student.nisn}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}