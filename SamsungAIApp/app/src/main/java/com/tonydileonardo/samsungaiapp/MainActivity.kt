package com.tonydileonardo.samsungaiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tonydileonardo.samsungaiapp.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    VoicePrototypeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun VoicePrototypeScreen(modifier: Modifier = Modifier) {
    var transcript by remember { mutableStateOf("Tap Start to simulate speech input.") }
    var aiReply by remember { mutableStateOf("Your spoken reply will appear here.") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Samsung AI App",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(text = "STT + TTS prototype")
        OutlinedTextField(
            value = transcript,
            onValueChange = { transcript = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Transcript") }
        )
        OutlinedTextField(
            value = aiReply,
            onValueChange = { aiReply = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("AI reply") }
        )
        Button(onClick = {
            transcript = "Simulated speech: turn on the lights."
            aiReply = "Simulated AI: turning on the lights now."
        }) {
            Text("Start demo")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Next step: connect real STT and TTS.")
    }
}

@Preview(showBackground = true)
@Composable
fun VoicePrototypePreview() {
    MyApplicationTheme {
        VoicePrototypeScreen()
    }
}
