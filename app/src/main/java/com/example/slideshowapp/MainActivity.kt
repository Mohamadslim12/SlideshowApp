package com.example.slideshowapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slideshowapp.data.Datasource
import com.example.slideshowapp.model.Sushi
import com.example.slideshowapp.ui.theme.SlideshowAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SlideshowAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    SushiApp()
                }
            }
        }
    }
}

@Composable
fun SushiApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFB3E5FC))
            .padding(16.dp)
    ) {
        SushiList(sushis = Datasource.loadSushis())
    }
}

@Composable
fun SushiList(sushis: List<Sushi>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(horizontal = 8.dp)) {
        items(sushis) { sushi ->
            SushiCard(sushi = sushi, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun SushiCard(sushi: Sushi, modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column {
            Image(
                painter = painterResource(id = sushi.imageRes),
                contentDescription = stringResource(id = sushi.nameRes),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = sushi.nameRes),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SushiAppPreview() {
    SlideshowAppTheme {
        SushiApp()
    }
}





