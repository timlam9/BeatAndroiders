package com.timlam.beatandroiders.presentation.navigation

const val ANDROIDER_ID = "androider_id"

sealed class Screen(open val route: String = "") {

    object Main : Screen("main")

    object Details : Screen("details/{$ANDROIDER_ID}")

}
