package com.example.projectskripsi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.projectskripsi.ui.navigation.AppNavigation
import com.example.projectskripsi.ui.screen.AnnouncementViewModel
import com.example.projectskripsi.ui.screen.StudentViewModel
import com.example.projectskripsi.ui.theme.ProjectSkripsiTheme

class MainActivity : ComponentActivity() {

    private val announcementViewModel: AnnouncementViewModel by viewModels()
    private val studentViewModel: StudentViewModel by viewModels() // Inisialisasi StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectSkripsiTheme {
                AppNavigation(
                    announcementViewModel = announcementViewModel,
                    studentViewModel = studentViewModel // Teruskan StudentViewModel ke AppNavigation
                )
            }
        }
    }
}

@Preview
@Composable
private fun AppPreview() {
    val navController = rememberNavController()
    val announcementViewModel = AnnouncementViewModel()
    val studentViewModel = StudentViewModel() // Inisialisasi StudentViewModel

    ProjectSkripsiTheme {
        AppNavigation(
            announcementViewModel = announcementViewModel,
            studentViewModel = studentViewModel)

    }

}