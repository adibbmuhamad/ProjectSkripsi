package com.example.projectskripsi.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun StudentDetailPage(
    navController: NavController,
    modifier: Modifier = Modifier,
    studentDetailViewModel: StudentDetailViewModel = viewModel(),
    studentId: Int,
    viewModel: StudentDetailViewModel,
    ) {
    studentDetailViewModel.getStudentDetail(studentId)
    val studentDetail = studentDetailViewModel.selectedStudent.value
    val isLoading = studentDetailViewModel.isLoading.value
    val errorMessage = studentDetailViewModel.errorMessage.value

    if (isLoading) {
        Text("Loading...")
    } else if (errorMessage.isNotEmpty()) {
        Text(errorMessage)
    } else {
        studentDetail?.let {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Name: ${it.name}")
                Text(text = "Class Room: ${it.classRoom}")
                Text(text = "NISN: ${it.nisn}")
                Text(text = "Address: ${it.address}")
            }
        }
    }
}