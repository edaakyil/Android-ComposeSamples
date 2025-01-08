package com.edaakyil.android.composetutorial.view

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edaakyil.android.composetutorial.R
import com.edaakyil.android.composetutorial.model.Message
import com.edaakyil.android.composetutorial.ui.theme.ComposeTutorialTheme

@Composable
fun MessageCard(msg: Message) {
    ComposeTutorialTheme {
        Surface {
            // Add padding around our message
            Row(modifier = Modifier.padding(all = 8.dp)) {
                Image(
                    painter = painterResource(R.drawable.profile_picture),
                    contentDescription = "Contact profile picture",
                    modifier = Modifier
                        .size(40.dp) // Set image size to 40 dp
                        .clip(CircleShape) // Clip image to be shaped as a circle
                        .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp)) // Add a horizontal space between the image and the column

                // We keep track if the message is expanded or not in this variable
                var isExpanded by remember { mutableStateOf(false) }

                // surfaceColor will be updated gradually from one color to the other
                val surfaceColor by animateColorAsState(if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface)

                Column(
                    modifier = Modifier.clickable { isExpanded = !isExpanded } // We toggle the isExpanded variable when we click on this Column
                ) {
                    Text(
                        text = msg.author,
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.titleSmall
                    )
                    Spacer(modifier = Modifier.height(4.dp)) // Add a vertical space between the author and message texts
                    Surface(
                        color = surfaceColor, // surfaceColor color will be changing gradually from primary to surface
                        shadowElevation = 1.dp,
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier.animateContentSize().padding(1.dp) // animateContentSize will change the Surface size gradually
                    ) {
                        Text(
                            text = msg.text,
                            modifier = Modifier.padding(all = 4.dp),
                            style = MaterialTheme.typography.bodyMedium,
                            maxLines = if (isExpanded) Int.MAX_VALUE else 1, // If the message is expanded, we display all its content otherwise we only display the first line
                        )
                    }
                }
            }
        }
    }
}

@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(name = "Light Mode")
@Composable
fun MessageCardPreview() {
    MessageCard(
        msg = Message("Lexi", "Hey, take a look at Jetpack Compose, it's great!")
    )
}
