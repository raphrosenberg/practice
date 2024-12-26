package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    ArtDisplay(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtDisplay(modifier: Modifier = Modifier) {
    val art: Painter
    val artist: String
    val title: String
    val year: String
    val clickFunNext: () -> Unit
    val clickFunPrev: () -> Unit

    var artStage by remember { mutableStateOf(1) }

    // Cycle through artwork, recycle to beginning when artStage == 6
    when (artStage) {
        1 -> {
            art = painterResource(R.drawable.artwork_1)
            artist = stringResource(R.string.artist_name_1)
            title = stringResource(R.string.artwork_title_1)
            year = stringResource(R.string.artwork_year_1)
            clickFunNext = { artStage++ }
            clickFunPrev = { artStage = 6 }

        }
        2 -> {
            art = painterResource(R.drawable.artwork_2)
            artist = stringResource(R.string.artist_name_2)
            title = stringResource(R.string.artwork_title_2)
            year = stringResource(R.string.artwork_year_2)
            clickFunNext = { artStage++ }
            clickFunPrev = { artStage-- }        }
        3 -> {
            art = painterResource(R.drawable.artwork_3)
            artist = stringResource(R.string.artist_name_3)
            title = stringResource(R.string.artwork_title_3)
            year = stringResource(R.string.artwork_year_3)
            clickFunNext = { artStage++ }
            clickFunPrev = { artStage-- }
        }
        4 -> {
            art = painterResource(R.drawable.artwork_4)
            artist = stringResource(R.string.artist_name_4)
            title = stringResource(R.string.artwork_title_4)
            year = stringResource(R.string.artwork_year_4)
            clickFunNext = { artStage++ }
            clickFunPrev = { artStage-- }
        }
        5 -> {
            art = painterResource(R.drawable.artwork_5)
            artist = stringResource(R.string.artist_name_5)
            title = stringResource(R.string.artwork_title_5)
            year = stringResource(R.string.artwork_year_5)
            clickFunNext = { artStage++ }
            clickFunPrev = { artStage-- }
        }
        else -> {
            art = painterResource(R.drawable.artwork_6)
            artist = stringResource(R.string.artist_name_6)
            title = stringResource(R.string.artwork_title_6)
            year = stringResource(R.string.artwork_year_6)
            clickFunNext = { artStage = 1 }
            clickFunPrev = { artStage-- }
        }
    }

    ArtworkWallTextAndNav(
        artWork = art,
        artist = artist,
        artTitle = title,
        artYear = year,
        modifier = modifier,
        clickFunNext = clickFunNext,
        clickFunPrev = clickFunPrev
    )
}

@Composable
fun ArtworkWallTextAndNav(
    artWork: Painter,
    artist: String,
    artTitle: String,
    artYear: String,
    modifier: Modifier,
    clickFunNext: () -> Unit,
    clickFunPrev: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .wrapContentSize()
            .fillMaxHeight()
    ) {
        // Artwork
        Image(
            painter = artWork,
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .wrapContentSize()
                .size(500.dp)
                //.width(360.dp)
                //.height(500.dp)
                .padding(4.dp)
                // Ensure Image is placed first
                .weight(1f)
                .border(border = BorderStroke(40.dp, Color(0xFFFFFFFF)), shape = RectangleShape)
                .shadow(shape = RectangleShape, elevation = 40.dp)
        )

        // Label
        Column(
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, bottom = 16.dp)
                .background(color = Color(0xFFECEBF4))
        ) {
            Text(
                text = artTitle,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
            )
            Row {
                Text(
                    text = artist,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 16.dp, end = 2.dp, bottom = 16.dp)
                )
                Text(
                    text = "($artYear)",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(end = 16.dp, bottom = 16.dp)
                )
            }
        }
        // Buttons
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Button(
                onClick = clickFunPrev,
                shape = RoundedCornerShape(32.dp),
                modifier = Modifier
                    .padding(4.dp)
                    .size(160.dp, 40.dp)
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = clickFunNext,
                shape = RoundedCornerShape(32.dp),
                modifier = Modifier
                    .padding(4.dp)
                    .size(160.dp, 40.dp)
            ) {
                Text(text = "Next")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ArtDisplayPreview() {
    ArtSpaceTheme {
        ArtDisplay()
    }
}