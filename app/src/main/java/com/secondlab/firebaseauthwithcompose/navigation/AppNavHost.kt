package com.secondlab.firebaseauthwithcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.secondlab.firebaseauthwithcompose.ui.auth.AuthViewModel
import com.secondlab.firebaseauthwithcompose.ui.auth.LoginScreen
import com.secondlab.firebaseauthwithcompose.ui.auth.SignUpScreen
import com.secondlab.firebaseauthwithcompose.ui.home.HomeScreen

@Composable
fun AppNavHost(
    viewModel: AuthViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_LOGIN,
) {
    NavHost(modifier = Modifier,
        navController = navController,
        startDestination = startDestination) {
        composable(ROUTE_LOGIN) {
            LoginScreen(viewModel, navController)
        }
        composable(ROUTE_SIGN_UP) {
            SignUpScreen(viewModel, navController)
        }
        composable(ROUTE_HOME) {
            HomeScreen(viewModel, navController)
        }
    }
}