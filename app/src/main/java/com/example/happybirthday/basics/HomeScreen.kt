package com.example.happybirthday.basics

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.happybirthday.R


@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier, navController: NavHostController) {
    val painter = painterResource(R.drawable.androidparty)
    val context = LocalContext.current
    Box (

    ) {
        Image(
            painter = painter,
            contentDescription = null
        )
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
//                .align(alignment = Alignment.CenterHorizontally)
        )
        OutlinedButton(
            onClick = { 
                navController.navigate("screen2")
            }
        ) {
            Text(
                text = "Next screen"
            )
        }
    }
//    Column(
//        verticalArrangement = Arrangement.Center,
//        modifier = modifier
//    ) {
//        Text(
//            text = message,
//            fontSize = 100.sp,
//            lineHeight = 116.sp,
//            textAlign = TextAlign.Center
//        )
//        Image(
//            painter = painter,
//            contentDescription = null
//        )
//        Text(
//            text = from,
//            fontSize = 36.sp,
//            modifier = Modifier
//                .padding(16.dp)
//                .align(alignment = Alignment.CenterHorizontally)
//        )
//    }
}