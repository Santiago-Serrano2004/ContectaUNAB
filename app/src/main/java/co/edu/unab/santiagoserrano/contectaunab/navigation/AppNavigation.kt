package co.edu.unab.santiagoserrano.contectaunab.navigation

import android.net.Uri
import android.provider.ContactsContract
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.edu.unab.santiagoserrano.contectaunab.R
import co.edu.unab.santiagoserrano.contectaunab.screens.Notifications
import co.edu.unab.santiagoserrano.contectaunab.screens.PantallaCarga
import co.edu.unab.santiagoserrano.contectaunab.screens.PantallaPrincipalTutor
import co.edu.unab.santiagoserrano.contectaunab.screens.Profile
import co.edu.unab.santiagoserrano.contectaunab.screens.Settings

@Composable
fun AppNavigation() {

    // NavController: encargado de gestionar las rutas y la navegación
    val navController = rememberNavController()

    // NavHost: define las rutas y la acción a realizar para cada una
    NavHost(navController = navController, startDestination = AppScreens.PantallaCarga.route) {

        composable(AppScreens.PantallaCarga.route) {
            PantallaCarga(navController) }

        composable(AppScreens.PantallaPrincipalTutor.route) {
            PantallaPrincipalTutor(navController) }

        composable(AppScreens.Profile.route){
            Profile(navController) }

        composable(AppScreens.Notifications.route){
            Notifications(navController) }

        composable(AppScreens.Settings.route){
            Settings(navController)
        }

    }
}