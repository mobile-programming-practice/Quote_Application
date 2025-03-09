package com.example.quote_app.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quote_app.screens.HomeScreen
import com.example.quote_app.screens.InfoScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Quote_AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationSetupForApp(modifier =
                    Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}

@Composable
fun Quote_App(modifier: Modifier = Modifier) {
    Text(
        text = "Welcome to quote app",
        modifier = modifier
    )
}

//navigation setup for the app
@Composable
fun NavigationSetupForApp(modifier: Modifier = Modifier) {
    //create navigation controller
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        //default screen is HomeScreen
        startDestination = "home"
    ) {
        //define routes for navigation
        composable(route = "home") {
            HomeScreen(navController = navController, modifier = modifier)
        }
        composable(route = "info") {
            InfoScreen(navController = navController, modifier = modifier)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Quote_AppTheme {
        Quote_App()
    }
}
