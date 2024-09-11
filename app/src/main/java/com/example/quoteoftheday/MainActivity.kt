package com.example.quoteoftheday

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.example.quoteoftheday.ui.theme.QuoteOfTheDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuoteOfTheDayTheme {
                CreateButton()
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun CreateButton() {

    var quoteGenerator by remember{ mutableIntStateOf(0) }
    Column{
        Button(onClick = { quoteGenerator = (quoteGenerator + 1) % 3 }) {
            Text("Click Me")
        }
        //Using switch because I am too lazy to code randomization for my quotes
            when (quoteGenerator){
                0 -> Text(text = "You must be the change you wish to see in the world - Mahatma Gandhi", fontFamily = FontFamily.SansSerif, color = Color.Magenta)
                1 -> Text(text = "The only thing we have to fear is fear itself. -Franklin D. Roosevelt", fontFamily = FontFamily.SansSerif, color = Color.DarkGray)
                2 -> Text(text = "Well done is better than well said. -Benjamin Franklin", fontFamily = FontFamily.SansSerif, color = Color.Gray)
            }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuoteOfTheDayTheme {
        Greeting("Android")
    }
}