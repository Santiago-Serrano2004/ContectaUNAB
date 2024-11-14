package co.edu.unab.santiagoserrano.contectaunab.navigation

import android.net.Uri
import android.provider.ContactsContract
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import co.edu.unab.santiagoserrano.contectaunab.R
import co.edu.unab.santiagoserrano.contectaunab.screens.IngresoHorario
import co.edu.unab.santiagoserrano.contectaunab.screens.LoginScreen
import co.edu.unab.santiagoserrano.contectaunab.screens.Notifications
import co.edu.unab.santiagoserrano.contectaunab.screens.PantallaCarga
import co.edu.unab.santiagoserrano.contectaunab.screens.PantallaPrincipalEstudiante
import co.edu.unab.santiagoserrano.contectaunab.screens.PantallaPrincipalTutor
import co.edu.unab.santiagoserrano.contectaunab.screens.Profile
import co.edu.unab.santiagoserrano.contectaunab.screens.RegistrationScreen
import co.edu.unab.santiagoserrano.contectaunab.screens.RoleSelectionScreen
import co.edu.unab.santiagoserrano.contectaunab.screens.Settings

import co.edu.unab.santiagoserrano.contectaunab.screens.WelcomeScreen

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
            Settings(navController) }


        composable(AppScreens.PantallaInicio.route){
            WelcomeScreen(navController)
        }
        composable(AppScreens.PantallaLogin.route){
            LoginScreen(navController)
        }

        composable(AppScreens.PantallaRegistro.route){
            RegistrationScreen(navController)
        }

        composable(AppScreens.PantallaPrincipalEstudiante.route){
            PantallaPrincipalEstudiante(navController)
        }

        composable(AppScreens.PantallaSeleccionRol.route){
            RoleSelectionScreen(onRoleSelected = { /* Manejo de selección */ }, navController)
        }

    }
}