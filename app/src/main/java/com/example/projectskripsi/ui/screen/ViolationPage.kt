package com.example.projectskripsi.ui.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ViolationPage(navController: NavController, modifier: Modifier = Modifier) {
    Text("hallo")

}

@Preview
@Composable
private fun ViolationPagePreview() {
    ViolationPage(navController = NavHostController(LocalContext.current))
}