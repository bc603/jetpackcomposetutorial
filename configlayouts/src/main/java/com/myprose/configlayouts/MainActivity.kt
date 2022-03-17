package com.myprose.configlayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
        }
    }

    data class Message(val author: String, val body: String)

    /* Define a composable function */
    @Composable
    fun MessageCard(msg: Message) {
        // Add padding around our message
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image (
                painter = painterResource(id = R.drawable.sticker),
                contentDescription = "Shinning Start",
                // modifier를 통해 사이즈 조절
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)

            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(msg.author)
                Spacer(Modifier.height(4.dp))
                Text(msg.body)
            }
        }

    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard(
            msg = Message("Colleague", "Hey, take a look at Jetpack")
        )
    }
}