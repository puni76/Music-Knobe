package com.example.jetpack_compose_music_knob_ex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose_music_knob_ex.ui.theme.JetpackcomposemusicknobexTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposemusicknobexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xff101010))
                        ){
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .border(1.dp, Color.Green, RoundedCornerShape(10.dp))
                                    .padding(30.dp)
                            ) {
                                var volume by remember {
                                    mutableStateOf(0f)
                                }
                                var barCount = 20
                                MusicKnob(
                                    modifier = Modifier.size(100.dp)
                                ){
                                    volume = it
                                }
                                Spacer(modifier = Modifier.width(20.dp))
                                VolumeBar(
                                    modifier = Modifier.fillMaxWidth().height(30.dp ),
                                    activeBars = (barCount*volume).roundToInt(),
                                    barCount = barCount
                                )
                            }
                    }
                }
            }
        }
    }
}

