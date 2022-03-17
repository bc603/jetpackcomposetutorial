package com.myprose.usematerialdesign

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message("Android", "Jetpack Compose"))
            // 해당테마를 어디서 선언하냐고
            /*ComposeTutorialTheme {
                MessageCard(Message("Android", "Jetpack Compose"))
            }*/
        }
    }

    data class Message(val author: String, val body: String)

    /* Define a composable function */
    @Composable
    fun MessageCard(msg: Message) {
        // Add padding around our message
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image (
                painter = painterResource(id = R.drawable.stickerc),
                contentDescription = "Shinning Start",
                // modifier를 통해 사이즈 조절
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text (
                    text = msg.author,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(Modifier.height(4.dp))
                Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                    Text (
                        text = msg.body,
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }

    }

    /* enable dark mode */
    @Preview(name = "Light Mode")
    @Preview(
        uiMode =  Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode",
    )
    @Composable
    fun PreviewMessageCard() {
        MessageCard(
            msg = Message("Colleague", "Hey, take a look at Jetpack")
        )

        // ComoseTutorialTheme를 어디서 선언하는거냐?
        /*ComposeTutorialTheme {
            msg = Message("Colleague", "Take a look at Jetpack Compose")
        }*/
    }
}