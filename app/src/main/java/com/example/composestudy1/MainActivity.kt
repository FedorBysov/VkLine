package com.example.composestudy1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.composestudy1.ui.theme.Composestudy1Theme
import com.example.composestudy1.ui.theme.MainScreen

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Composestudy1Theme {
                MainScreen(viewModel)
            }

        }
    }
}



