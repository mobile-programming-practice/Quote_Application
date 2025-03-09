package com.example.quote_app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import com.example.quote_app.viewmodel.QuoteViewModel

//homeScreen to display random quote with a Next button
@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier, quoteViewModel: QuoteViewModel = viewModel()) {

    //column to display the random quote and buttons
    Column(
        modifier = modifier.padding(16.dp),
        //verticalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        //to display title
        Text(
            text = stringResource(R.string.quote_of_the_day),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        //display current random quote from ViewModel
        Text(text = quoteViewModel.currentQuote, style = MaterialTheme.typography.headlineLarge)

        //next button to generate a new random quote
        Button(onClick = {
            //fetch a new random quote
            quoteViewModel.fetchRandomQuote()
        }) {
            Text(stringResource(R.string.next))
        }

        //info button to navigate to the Info screen
        Button(onClick = {
            navController.navigate("info")
        }) {
            Text(stringResource(R.string.info))
        }
    }
}
