package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Quadrants()
                }
            }
        }
    }
}

@Composable
fun Quadrants(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxWidth()) {
        Row (modifier = modifier.weight(1.0f)) {
            QuadPane(
                title = stringResource(R.string.comp_title_1),
                body = stringResource(R.string.comp_body_1),
                bgColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1.0f),
            )
            QuadPane(
                title = stringResource(R.string.comp_title_2),
                body = stringResource(R.string.comp_body_2),
                bgColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1.0f),
            )
        }
        Row (modifier = modifier.weight(1.0f)) {
            QuadPane(
                title = stringResource(R.string.comp_title_3),
                body = stringResource(R.string.comp_body_3),
                bgColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1.0f),
            )
            QuadPane(
                title = stringResource(R.string.comp_title_4),
                body = stringResource(R.string.comp_body_4),
                bgColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1.0f),
            )
        }
    }
}

@Composable
fun QuadPane(
    title: String,
    body: String,
    bgColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
        )
        Text(
            text = body,
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Quadrants()
    }
}