package com.edaakyil.android.compose_viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.edaakyil.android.compose_viewmodel.ui.GameScreen
import com.edaakyil.android.compose_viewmodel.ui.theme.UnscrambleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            UnscrambleTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    GameScreen()
                }
            }
        }
    }
}