package com.hamaar.maverickapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.hamaar.maverickapps.ui.theme.MaverickappsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaverickappsTheme {
                MainScreen()
            }
        }
    }
}