package com.edaakyil.android.composetutorial.view

import com.edaakyil.android.composetutorial.repository.SampleData
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.tooling.preview.Preview
import com.edaakyil.android.composetutorial.model.Message
import com.edaakyil.android.composetutorial.ui.theme.ComposeTutorialTheme

@Composable
fun Conversation(messages: List<Message>) {
        ComposeTutorialTheme {
            LazyColumn {
                items(messages) { message -> MessageCard(message) }
            }
        }
}

@Preview
@Composable
fun ConversationPreview() {
    Conversation(SampleData.conversationSample)
}
