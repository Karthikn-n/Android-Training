package com.example.happybirthday.basics

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.happybirthday.R

@Composable
fun ComposeTutorial(modifier: Modifier, navController: NavHostController) {
    val painter = painterResource(R.drawable.bg_compose_background)
    val scrollController = rememberScrollState()
    Column(
        modifier = modifier.verticalScroll(scrollController).fillMaxSize()
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = stringResource(R.string.jetpack_compose_tutorial),
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = stringResource(R.string.first_section),
            modifier = modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = stringResource(R.string.second_section),
            modifier = modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
        OutlinedButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            Text("Back", color = Color.White)
        }
        FilledIconButton (
            onClick = {
                navController.navigate("screen3")
            },
            modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            Text("Next", color = Color.White)
        }
    }
}