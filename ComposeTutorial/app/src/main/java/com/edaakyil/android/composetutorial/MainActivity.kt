package com.edaakyil.android.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.edaakyil.android.composetutorial.repository.SampleData
import com.edaakyil.android.composetutorial.view.Conversation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Conversation(SampleData.conversationSample)
        }
    }
}

