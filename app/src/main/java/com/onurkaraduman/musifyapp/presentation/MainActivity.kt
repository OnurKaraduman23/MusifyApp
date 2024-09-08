package com.onurkaraduman.musifyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.onurkaraduman.musifyapp.design_system.theme.MusifyAppTheme
import com.onurkaraduman.musifyapp.presentation.navgraph.NavGraph
import com.onurkaraduman.musifyapp.presentation.navgraph.Route

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusifyAppTheme {
                NavGraph(Route.HomeScreen.route)
            }
        }
    }
}
