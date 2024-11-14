package co.edu.unab.santiagoserrano.contectaunab.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import co.edu.unab.santiagoserrano.contectaunab.StudentMainContent2
import co.edu.unab.santiagoserrano.contectaunab.StudentMainNavBar2
import co.edu.unab.santiagoserrano.contectaunab.StudentMainHeader2

@Composable
fun PantallaPrincipalEstudiante(navController: NavController) {
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme
    ) {
        Scaffold(
            topBar = { StudentMainHeader2() },
            content = { paddingValues ->
                // Uso de LazyColumn para manejar el contenido desplazable
                Column(
                    modifier = Modifier
                        .fillMaxSize() // Aseguramos que ocupe el tamaño disponible
                        .padding(paddingValues) // Aplicamos el padding del Scaffold
                ) {
                    // Aquí agregamos el contenido que debe ser desplazable
                        StudentMainContent2()
                }
            },
            bottomBar = { StudentMainNavBar2(navController = navController) }
        )
    }
}
