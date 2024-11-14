package co.edu.unab.santiagoserrano.contectaunab.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.edu.unab.santiagoserrano.contectaunab.screens.PantallaPrincipalTutor

@Composable
fun AppNavigation() {
    // NavController: encargado de gestionar las rutas y la navegación
    val navController = rememberNavController()

    // NavHost: define las rutas y la acción a realizar para cada una
    NavHost(navController = navController, startDestination = AppScreens.PantallaPrincipalTutor.route) {
        composable(AppScreens.PantallaPrincipalTutor.route) {
            PantallaPrincipalTutor(navController) }

        composable(AppScreens.Profile.route){
            Profile(navController) }

        composable(AppScreens.Notifications.route){
            Notifications(navController) }

        composable(AppScreens.Settings.route){
            Settings(navController) }

    }
}