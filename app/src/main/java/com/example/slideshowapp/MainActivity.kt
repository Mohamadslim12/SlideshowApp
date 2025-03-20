package com.example.slideshowapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slideshowapp.ui.theme.SlideshowAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SlideshowAppTheme {
                SlideshowApp()
            }
        }
    }
}

@Composable
fun SlideshowApp() {
    var currentIndex by remember { mutableStateOf(0) }
    var textInput by remember { mutableStateOf("") }

    val images = listOf(
        R.drawable.futomaki,
        R.drawable.nigiri,
        R.drawable.onigiri,
        R.drawable.gunkan_maki,
        R.drawable.temaki,
        R.drawable.uramaki
    )
    val captions = listOf(
        "1. Futo Maki",
        "2. Nigiri",
        "3. Onigiri",
        "4. Gunkan Maki",
        "5. Temaki",
        "6. Ura Maki"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFB3E5FC))
            .padding(16.dp)
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = images[currentIndex]),
            contentDescription = stringResource(R.string.displayed_image),
            modifier = Modifier
                .size(400.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = captions[currentIndex])
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(
                onClick = { currentIndex = if (currentIndex == 0) images.size - 1 else currentIndex - 1 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = androidx.compose.material3.MaterialTheme.colorScheme.primary
                )
            ) {
                Text(text = stringResource(R.string.back))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { currentIndex = if (currentIndex == images.size - 1) 0 else currentIndex + 1 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = androidx.compose.material3.MaterialTheme.colorScheme.primary
                )
            ) {
                Text(text = stringResource(R.string.next))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = textInput,
            onValueChange = { newText ->
                textInput = newText
                val number = textInput.toIntOrNull()
                if (number != null && number in 1..images.size) {
                    currentIndex = number - 1
                }
            },
            label = { Text(stringResource(R.string.enter_picture_number)) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SlideshowAppPreview() {
    SlideshowAppTheme {
        SlideshowApp()
    }
}



