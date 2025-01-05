package com.example.classgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.classgrid.data.DataSource
import com.example.classgrid.model.Topic
import com.example.classgrid.ui.theme.ClassGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClassGridTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                        ClassGridApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ClassGridApp(modifier: Modifier = Modifier) {
    ClassGrid(
        topicList = DataSource.loadTopics(),
        modifier = modifier
    )
}

@Composable
fun ClassGrid(topicList: List<Topic>, modifier: Modifier = Modifier ) {
    LazyVerticalGrid(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        columns = GridCells.Fixed(2),
        modifier = modifier.padding(8.dp)
    ) {
        items(topicList) { topic ->
            TopicCard(
                topic = topic,
                modifier = modifier
            )
            TopicCard(
                topic = topic,
                modifier = modifier
            )
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .height(68.dp)
            .aspectRatio(
                matchHeightConstraintsFirst = true,
                ratio = 2.8f
            )
    ) {
        Row {
            Image(
                painter = painterResource(topic.topicImage),
                contentDescription = stringResource(topic.topicName),
                modifier =  Modifier
                    .height(68.dp)
                    .width(68.dp)
            )
            Column {
                Text(
                    text = stringResource(topic.topicName),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 16.dp)
                    )
                    Text(
                        text = topic.numberOfCourses.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopicCardPreview() {
    val topic = Topic(R.string.architecture, 58, R.drawable.architecture)

    TopicCard (
        topic = topic,
    )
}