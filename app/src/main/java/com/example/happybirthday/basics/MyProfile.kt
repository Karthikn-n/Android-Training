package com.example.happybirthday.basics

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.happybirthday.R

@Composable
fun MyProfile(navigator: NavHostController) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(
            color = Color(0xFFd2e8d4)
        )
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Profile(Modifier)
        Spacer(modifier = Modifier.weight(1f))
        ContactDetail()
        Spacer(modifier = Modifier.height(28.dp))
    }
}

@Composable
private fun Profile(modifier: Modifier = Modifier) {
    val painter = painterResource(R.drawable.android_logo)
    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier
            .width(128.dp)
            .height(128.dp)
            .background(color = Color(0xFF073042))
            .padding(16.dp),

    )
    Text(
        text = stringResource(R.string.name),
        fontSize = 42.sp,
        fontWeight = FontWeight.W300,
        color = Color.Black,
        modifier = modifier.padding(top = 5.dp)
    )
    Text(
        text = stringResource(R.string.title),
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color(0xFF046d3b),
        modifier = modifier.padding(top = 10.dp)
    )
}

@Composable
private fun ContactDetail(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom,
    ) {
        ContactDetailCard(
            modifier = modifier.padding(bottom = 10.dp, top = 10.dp),
            icon = Icons.Default.Phone,
            title = stringResource(R.string.phone_no)
        )
        ContactDetailCard(
            modifier = modifier.padding(bottom = 10.dp),
            icon = Icons.Default.Share,
            title = stringResource(R.string.git_profile)
        )
        ContactDetailCard(
            modifier = modifier,
            icon = Icons.Default.Email,
            title = stringResource(R.string.email)
        )
    }
}

@Composable
private fun ContactDetailCard(modifier: Modifier = Modifier, icon: ImageVector, title: String) {
    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = Color(0xFF006d3b),
            modifier = modifier.size(24.dp)
        )
        Text(
            text = title,
            color = Color.Black,
            modifier = modifier.padding(start = 16.dp)
        )
    }
}