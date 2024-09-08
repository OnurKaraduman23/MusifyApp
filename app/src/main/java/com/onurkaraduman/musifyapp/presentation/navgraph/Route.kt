package com.onurkaraduman.musifyapp.presentation.navgraph

sealed class Route(
    val route: String
) {
    data object OnBoardingScreen : Route(route = "onBoardingScreen")
    data object HomeScreen : Route(route = "homeScreen")
    data object SearchScreen : Route(route = "searchScreen")
    data object ProfileScreen : Route(route = "profileScreen")
    data object MusifyNavigation : Route(route = "musifyNavigation")
    data object MusifyNavigatorScreen : Route(route = "musifyNavigatorScreen")
    data object AppStartNavigation : Route(route = "appStartNavigation")
}