package com.example.composestudy1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.composestudy1.ui.theme.Composestudy1Theme
import com.example.composestudy1.ui.theme.InstagramProfileCard
import com.example.composestudy1.ui.theme.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainViewModel ::class.java]
        setContent {
            Composestudy1Theme {
                InstagramProfileCard(viewModel = viewModel)
            }

        }
    }
}



