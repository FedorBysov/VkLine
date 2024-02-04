package com.example.composestudy1.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.composestudy1.R

sealed class NavigationItem(val titleResId: Int, val icon: ImageVector) {
    object Home :
        NavigationItem(titleResId = R.string.navigation_main_name, icon = Icons.Outlined.Home)

    object Like :
        NavigationItem(titleResId = R.string.navigation_main_like, icon = Icons.Outlined.Favorite)

    object Profile :
        NavigationItem(titleResId = R.string.navigation_main_profile, icon = Icons.Outlined.Person)

}