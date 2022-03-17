package com.myprose.jetpakcompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    /* Add Text Element */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContent {
            Text("Hello World")
        }*/
        /* The content will become the root view of the given activity */
        setContent {
            PreviewMessageCard() //@Composable Annotation은 @Composable Annotation 안에서 실행가능
        }
    }

    /* Define a composable function */
    @Composable
    fun MessageCard(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard("Jetpack Compose")
    }
}