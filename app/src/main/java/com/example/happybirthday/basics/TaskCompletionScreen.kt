package com.example.happybirthday.basics

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.happybirthday.R

@Composable
fun TaskCompletion(modifier: Modifier, navigator: NavHostController) {
    val painter = painterResource(R.drawable.ic_task_completed)
    val scrollController = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = modifier.verticalScroll(scrollController)
    ) {
        Image(
            painter = painter,
            contentDescription = null,
        )
        Text(
            text = stringResource(R.string.task_completed),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.nice_work),
            fontSize = 16.sp
        )
        OutlinedButton(
//            modifier = modifier.align(Alignment.BottomCenter),
            onClick = {
                navigator.navigate("screen4")
            }
        ) {
            Text(
                text = "Next",
                color = Color.White
            )
        }
    }
}