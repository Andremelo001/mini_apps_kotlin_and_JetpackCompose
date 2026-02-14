package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xFF3ddc84))
            .padding(bottom = 100.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .height(110.dp)
                .width(110.dp)
                .background(color = Color(red = 0, green = 52, blue = 92))
        )
        Text(
            text = stringResource(R.string.jennifer_doe),
            fontSize = 40.sp,
            modifier = Modifier
                .padding(top = 8.dp)
        )
        Text(
            text = stringResource(R.string.android_developer_extraordinaire),
            fontWeight = FontWeight.Bold,
            color = Color(red = 0, green = 100, blue = 0),
            modifier = Modifier
                .padding(top = 10.dp)
        )
    }
    IconsCard()
}

@Composable
fun IconsCard(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(bottom = 50.dp)
    ) {
        Column(modifier = Modifier.wrapContentWidth(Alignment.Start)) {
            Row(
                modifier = Modifier
                    .padding(bottom = 15.dp)
            ) {
                Icon(
                    Icons.Rounded.Call,
                    contentDescription = null,
                    tint = Color(red = 0, green = 100, blue = 0),
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                )
                Text(
                    text = stringResource(R.string._11_123_555_666)
                )

            }
            Row(modifier = Modifier.padding(bottom = 10.dp)) {
                Icon(
                    Icons.Rounded.Share,
                    contentDescription = null,
                    tint = Color(red = 0, green = 100, blue = 0),
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                )
                Text(
                    text = stringResource(R.string.androiddev)
                )

            }
            Row(modifier = Modifier.padding(top = 5.dp)) {
                Icon(
                    Icons.Rounded.Email,
                    contentDescription = null,
                    tint = Color(red = 0, green = 100, blue = 0),
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                )
                Text(
                    text = stringResource(R.string.jen_doe_android_com)
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        BusinessCard()
    }
}