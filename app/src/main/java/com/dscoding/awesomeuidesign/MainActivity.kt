package com.dscoding.awesomeuidesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.content.ContextCompat
import com.dscoding.awesomeuidesign.ui.theme.AwesomeUIDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)
        setContent {
            AwesomeUIDesignTheme {
                Navigation()
            }
        }
    }
}

