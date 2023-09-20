package com.example.jetpack_compose_music_knob_ex

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun VolumeBar(
    modifier: Modifier = Modifier,
    activeBars:Int=0,
    barCount:Int=10
){
    BoxWithConstraints(
        contentAlignment = Alignment.Center,
        modifier = Modifier .height(80.dp).width(150.dp).padding(start = 20.dp, bottom = 20.dp)



    ){
        val barWidth= remember {
            constraints.maxWidth/(2f * barCount)
        }
        Canvas(modifier=modifier){
            for (i in 0 until barCount){
                drawRoundRect(
                    color = if(i in 0..activeBars) Color.Green else Color.DarkGray,
                    topLeft = Offset(i*barWidth*2f+barWidth/2f, 0f),
                    size = Size(barWidth,constraints.maxHeight.toFloat()),
                    cornerRadius = CornerRadius(0f)
                )
            }
        }
    }
}