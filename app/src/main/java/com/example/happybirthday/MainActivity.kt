package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.happybirthday.basics.ComposeTutorial
import com.example.happybirthday.basics.GreetingText
import com.example.happybirthday.basics.Lemonade
import com.example.happybirthday.basics.MyProfile
import com.example.happybirthday.basics.QuadrantTutorial
import com.example.happybirthday.basics.TaskCompletion
import com.example.happybirthday.basics.TipCalculator
import com.example.happybirthday.ui.theme.HappyBirthdayTheme
import com.example.happybirthday.unit2.DiceWithButtonAndImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController, startDestination = "screen8") {
                        composable("screen1") { GreetingText(
                            message = stringResource(R.string.happy_birthday_sam),
                            from = stringResource(R.string.signature_text),
                            modifier = Modifier.padding(8.dp),
                            navController
                        )}
                        composable("screen2") { ComposeTutorial(Modifier, navController) }
                        composable("screen3") { TaskCompletion(Modifier, navController) }
                        composable("screen4") { QuadrantTutorial(Modifier, navController) }
                        composable("screen5") { MyProfile( navController) }
                        composable("screen6") { DiceWithButtonAndImage(
                            modifier = Modifier.fillMaxSize().wrapContentSize(align = Alignment.Center),
                            navController = navController
                        ) }
                        composable("screen7") { Lemonade(modifier = Modifier, navController = navController) }
                        composable("screen8") { TipCalculator(modifier = Modifier, navController = navController) }
                    }
                }
            }
        }
    }
}

