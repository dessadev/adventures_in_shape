package com.example.adventuresinshape

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    var scaleState by remember { mutableStateOf(1f) }

    LaunchedEffect(Unit) {
        delay(300)
        scaleState = 1.5f

        delay(1000)
        navController.navigate("inicio")
    }

    val scale by animateFloatAsState(
        targetValue = scaleState,
        animationSpec = androidx.compose.animation.core.tween(1000)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF4E9)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .size(170.dp)
                .scale(scale)
        )
    }
}