package com.example.happybirthday.basics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.happybirthday.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuadrantTutorial(modifier: Modifier, navigator: NavHostController) {
    // fillMaxWidth -> It will cover the entire width of the parent compose and takes height as much needed
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Quadrant"
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navigator.navigate("screen5")
            }) {
                Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Add")
            }
        },
        floatingActionButtonPosition = FabPosition.End,
    ) { innerPadding ->
        Column(modifier.fillMaxWidth().padding(innerPadding)) {
            // weight (1f) -> it will takes the 1/2 size of the parent composable in Column
            Row(modifier.weight(1f)) {
                QuadrantBox(
                    // weight (1f) -> it will takes the 1/2 size of the parent composable in Row
                    modifier = modifier.weight(1f),
                    title = stringResource(R.string.first_row),
                    content = stringResource(R.string.first_row_content),
                    color = Color(0xFFEADDFF),
                )
                QuadrantBox(
                    modifier = modifier.weight(1f),
                    title = stringResource(R.string.second_row),
                    content = stringResource(R.string.second_row_content),
                    Color(0xFFD0BCFF)
                )
            }
            Row(modifier.weight(1f)) {
                QuadrantBox(
                    modifier = modifier.weight(1f),
                    title = stringResource(R.string.third_row),
                    content = stringResource(R.string.third_row_content),
                    color = Color(0xFFB69DF8)
                )
                QuadrantBox(
                    modifier = modifier.weight(1f),
                    title = stringResource(R.string.fourth_row),
                    content = stringResource(R.string.first_row_content),
                    color = Color(0xFFF6EDFF)
                )
            }
        }
    }
}

@Composable
fun QuadrantBox(modifier: Modifier = Modifier, title: String, content: String, color: Color) {
    // To get the current screen size
//    val configuration = LocalConfiguration.current
//    val screenWidth = configuration.screenWidthDp.dp
//    val screenHeight = configuration.screenHeightDp.dp

    Column (
        modifier = modifier
            .background(color)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            color = Color.Black
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify,
            color = Color.Black
        )
    }
}