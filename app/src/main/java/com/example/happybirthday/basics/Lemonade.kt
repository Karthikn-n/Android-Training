package com.example.happybirthday.basics

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.happybirthday.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Lemonade(modifier: Modifier, navController: NavHostController) {
    var currentStep by remember { mutableIntStateOf(1) }

    var squeezeCount by remember { mutableIntStateOf(0) }
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors =  TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->
        Surface (modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White),
            color = Color.White
        ){
            when (currentStep) {
                1 -> LemonAndImage(
                    textLabelResourceId = R.string.lemonTreeTab,
                    contentDescriptionId = R.string.lemonTree,
                    drawableResourceId = R.drawable.lemon_tree,
                    modifier = modifier,
                    onImageClick = {
                        currentStep  = 2
                        squeezeCount = (2..4).random()
                    }
                )
                2 -> LemonAndImage(
                    textLabelResourceId = R.string.lemonTab,
                    contentDescriptionId = R.string.lemon,
                    drawableResourceId = R.drawable.lemon_squeeze,
                    modifier = modifier,
                    onImageClick = {
                        squeezeCount--
                        if (squeezeCount == 0) {
                            currentStep = 3
                        }
                    }
                )
                3 -> LemonAndImage(
                    textLabelResourceId = R.string.lemonadeTab,
                    contentDescriptionId = R.string.lemonade,
                    drawableResourceId = R.drawable.lemon_drink,
                    modifier = modifier,
                    onImageClick = {
                        currentStep = 4
                    }
                )
                4 -> LemonAndImage(
                    textLabelResourceId = R.string.emptyTab,
                    contentDescriptionId = R.string.empty,
                    drawableResourceId = R.drawable.lemon_restart,
                    modifier = modifier,
                    onImageClick = {
                        currentStep = 1
                    }
                )
            }
        }

    }
}


@Composable
fun LemonAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier
) {
    val painter = painterResource(drawableResourceId)
    Box(
        modifier = modifier,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {

                Image(
                    painter = painter,
                    contentDescription = stringResource(contentDescriptionId),
                    modifier = modifier.clip(RoundedCornerShape(16.dp))
                )

            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))
            Text(
                text = stringResource(textLabelResourceId),
                fontSize = 18.sp,
                color = Color.Black,
                modifier = modifier.padding(top = 16.dp)
            )
        }
    }

}