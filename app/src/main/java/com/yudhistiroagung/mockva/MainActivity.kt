package com.yudhistiroagung.mockva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

val bottomMenus = listOf(
    R.id.fragmentHome,
    R.id.fragmentAccount
)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.app_navigation_host)
        appBottomBar.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            val isMenuVisible = destination.id in bottomMenus
            appBottomBar.isVisible = isMenuVisible
        }
    }
}