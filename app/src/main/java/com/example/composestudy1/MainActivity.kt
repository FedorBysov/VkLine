package com.example.composestudy1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.example.composestudy1.instagram.InstagramProfileCard
import com.example.composestudy1.instagram.InstagramViewModel
import com.example.composestudy1.ui.theme.Composestudy1Theme
import com.example.composestudy1.ui.theme.MainScreen

class MainActivity : ComponentActivity() {



    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Composestudy1Theme {
                MainScreen(viewModel = viewModel)
            }

        }
    }
}







