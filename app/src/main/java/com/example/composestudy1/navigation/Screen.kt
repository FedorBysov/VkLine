package com.example.composestudy1.navigation

sealed class Screen(
    val route:String
){

    object HomeFeed : Screen(ROUTE_HOME_FEED)
    object Favorite : Screen(ROUTE_FAVORITE)
    object Profile : Screen(ROUTE_PROFILE)

    private companion object{
        const val ROUTE_HOME_FEED ="home_feed"
        const val ROUTE_FAVORITE = "favorite"
        const val ROUTE_PROFILE= "profile"
    }
}

