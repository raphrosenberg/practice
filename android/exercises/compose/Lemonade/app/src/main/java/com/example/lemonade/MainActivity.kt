@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeTreeWithButtonAndImages(
    lemonImage: Painter,
    lemonCD: String,
    lemonInstr: String,
    modifier: Modifier = Modifier,
    clickFun: () -> Unit,) {

    Column(
        modifier = modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxHeight()
        ) {
            Image(
                painter = lemonImage,
                contentDescription = lemonCD,
                modifier = Modifier
                    .wrapContentSize()
                    .background(
                        Color(0xFFC3ECD2),
                        shape = RoundedCornerShape(dimensionResource(R.dimen.background_radius)),
                    )
                    .height(dimensionResource(R.dimen.image_height))
                    .width(dimensionResource(R.dimen.image_width))
                    .clickable(onClick = clickFun)
            )
            Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.spacer_padding)))
            Text(
                text = lemonInstr,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    var lemonStage by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color(0xFFF9E44C)
                )
            )
        },
    ) { innerPadding ->
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .wrapContentSize(Alignment.Center)
        ) {
            when (lemonStage) {
                1 -> LemonadeTreeWithButtonAndImages(
                    painterResource(R.drawable.lemon_tree),
                    stringResource(R.string.tree_content_descr),
                    stringResource(R.string.lemon_tree_instr),
                ) {
                    squeezeCount = (2..4).random()
                    lemonStage = 2
                }

                2 -> LemonadeTreeWithButtonAndImages(
                    painterResource(R.drawable.lemon_squeeze),
                    stringResource(R.string.lemon_squeeze_instr),
                    stringResource(R.string.lemon_squeeze_instr),
                ) {
                    squeezeCount--
                    if (squeezeCount == 0) lemonStage = 3
                }

                3 -> LemonadeTreeWithButtonAndImages(
                    painterResource(R.drawable.lemon_drink),
                    stringResource(R.string.lemon_full_instr),
                    stringResource(R.string.lemon_full_content_descr),
                ) {
                    lemonStage++
                }

                else -> LemonadeTreeWithButtonAndImages(
                    painterResource(R.drawable.lemon_restart),
                    stringResource(R.string.lemon_empty_instr),
                    stringResource(R.string.lemon_empty_content_descr),
                ) {
                    lemonStage = 1
                }
            }
        }
    }
}