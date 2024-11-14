package co.edu.unab.santiagoserrano.contectaunab.navigation

sealed class AppScreens (val route: String) {
    object PantallaPrincipalTutor: AppScreens("PantallaPrincipalTutor")
    object Notifications: AppScreens("Notifications")
    object Profile: AppScreens("Profile")
    object Settings: AppScreens("Settings")
    object PantallaCarga: AppScreens("PantallaCarga")

}