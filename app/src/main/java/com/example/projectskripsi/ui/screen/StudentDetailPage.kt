package com.example.projectskripsi.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun StudentDetailPage(
    navController: NavController,
    viewModel: StudentDetailViewModel,
    studentId: Int,
    modifier: Modifier = Modifier
) {
    val studentDetail = remember { viewModel.selectedStudent }
    val isLoading = remember { viewModel.isLoading }
    val errorMessage = remember { viewModel.errorMessage }

    LaunchedEffect(studentId) {
        viewModel.getStudentDetail(studentId)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp, top = 32.dp)
    ) {
        if (isLoading.value) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else if (errorMessage.value.isNotEmpty()) {
            Text(text = errorMessage.value, color = MaterialTheme.colorScheme.error)
        } else {
            studentDetail.value?.let {
                Log.d("StudentDetailPage", "Displaying student detail: $it")
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = it.name,
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Divider()
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Gender: ${it.gender}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Class Room: ${it.class_room_id}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "NISN: ${it.nisn}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Address: ${it.address}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Parent Name: ${it.parent_name}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Parent Email: ${it.parent_email}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Phone Number: ${it.phone_number}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            } ?: run {
                Log.d("StudentDetailPage", "Student not found")
                Text(text = "Siswa tidak ditemukan", color = MaterialTheme.colorScheme.error)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StudentDetailPagePreview() {
    // Preview untuk menampilkan tampilan composable di editor
    StudentDetailPage(
        navController = NavController(LocalContext.current),
        viewModel = StudentDetailViewModel(),
        studentId = 1
    )
}