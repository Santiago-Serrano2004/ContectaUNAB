package co.edu.unab.santiagoserrano.contectaunab.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.edu.unab.santiagoserrano.contectaunab.AreasExperticiaScreen
import co.edu.unab.santiagoserrano.contectaunab.StudentMainContent
import co.edu.unab.santiagoserrano.contectaunab.StudentMainHeader
import co.edu.unab.santiagoserrano.contectaunab.StudentMainNavBar
import co.edu.unab.santiagoserrano.contectaunab.navigation.AppScreens

@Composable

fun PantallaPrincipalTutor(navController: NavController) {

    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme
    ) {
        Scaffold(topBar = { StudentMainHeader() },
            content = { paddingValues ->
                // El contenido principal de la pantalla
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues) // Respetamos los valores de padding del Scaffold
                ) {
                    StudentMainContent()
                    AreasExperticiaScreen()
                }
            }
            ,
            bottomBar = { StudentMainNavBar(navController = navController) })

    }
}

