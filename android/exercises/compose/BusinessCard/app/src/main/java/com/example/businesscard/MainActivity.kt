package com.example.businesscard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BusinessCard(
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(60.dp)
    ) {
        NameInfo(
            name = "Raphael Rosenberg",
            title = "Software Engineer"
        )
        ContactInfo(
            phone = "(650)123-4567",
            insta = "@doinstuff",
            email = "rr@gmail.com"
        )
    }
}

@Composable
fun NameInfo(name: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 80.dp, bottom = 20.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.width(80.dp).height(80.dp)
        )
        Text(
            text = name,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier.width(200.dp),
        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(200.dp)
        )
    }
}

@Composable
fun ContactInfo(phone: String, insta: String, email: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
    ) {
        Row() {
            Icon(Icons.Rounded.Call, contentDescription = "Call icon")
            Text(text = phone,)
        }
        Row() {
            Icon(Icons.Rounded.Share, contentDescription = "Call icon")
            Text(text = insta)
        }
        Row() {
            Icon(Icons.Rounded.Email, contentDescription = "Call icon")
            Text(text = email,)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}