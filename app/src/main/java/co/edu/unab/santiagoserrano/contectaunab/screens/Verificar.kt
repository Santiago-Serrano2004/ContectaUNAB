package co.edu.unab.santiagoserrano.contectaunab.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import co.edu.unab.santiagoserrano.contectaunab.navigation.AppScreens
import com.google.firebase.auth.FirebaseAuth

@Composable
fun Verificar(navController: NavController) {
    // Obtener el usuario actual
    val user = FirebaseAuth.getInstance().currentUser

    // Si hay un usuario autenticado, redirigir a la pantalla principal
    // Si no hay usuario, redirigir a la pantalla de login
    LaunchedEffect(key1 = user) {
        if (user != null) {
            // El usuario ya está autenticado, mostrar la pantalla principal
            navController.popBackStack() // Limpiar la pila anterior
            navController.navigate(AppScreens.PantallaSeleccionRol.route) // O la pantalla que quieras
        } else {
            // No hay usuario, ir al login
            navController.popBackStack() // Limpiar la pila anterior
            navController.navigate(AppScreens.PantallaInicio.route)
        }
    }
}