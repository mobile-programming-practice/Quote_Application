package com.example.quote_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.quote_app.R
import com.example.quote_app.ui.ErrorScreen
import com.example.quote_app.viewmodel.QuoteViewModel

//homeScreen to display random quote with a Next button
@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier, quoteViewModel: QuoteViewModel = viewModel()) {
    //get current system theme and adjust background color accordingly
    val backgroundColor = MaterialTheme.colorScheme.background

    //column to display the random quote and buttons
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        //verticalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        //to display title
        Text(
            text = stringResource(R.string.quote_of_the_day),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        //show ErrorScreen if an error occurs
        if (quoteViewModel.errorMessage != null) {
            ErrorScreen(quoteViewModel.errorMessage ?: "Unknown error", quoteViewModel)
        } else {
            // Display quote
            Text(
                text = quoteViewModel.currentQuote,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Fetch new quote button
            Button(
                onClick = { quoteViewModel.fetchRandomQuote() },
                modifier = Modifier.padding(bottom = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )

            ) {
                Text(stringResource(R.string.next))
            }

            // Navigate to Info screen button
            Button(onClick = { navController.navigate("info") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onSecondary
                )) {
                Text(stringResource(R.string.info))
            }
        }
    }
}