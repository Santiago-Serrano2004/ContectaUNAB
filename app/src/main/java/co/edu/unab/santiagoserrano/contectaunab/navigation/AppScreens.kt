package co.edu.unab.santiagoserrano.contectaunab.navigation

sealed class AppScreens (val route: String) {
    object PantallaPrincipalTutor: AppScreens("PantallaPrincipalTutor")
    object Notifications: AppScreens("Notifications")
    object Profile: AppScreens("Profile")
    object Settings: AppScreens("Settings")
    object PantallaCarga: AppScreens("PantallaCarga")
    object PantallaInicio: AppScreens("PantallaIncio")
    object PantallaLogin: AppScreens("PantallaLogin")
    object PantallaRegistro: AppScreens("PantallaRegistro")
    object PantallaSeleccionRol: AppScreens("PantallaSeleccionRol")
    object PantallaPrincipalEstudiante: AppScreens("PantallaPrincipalEstudiante")
}