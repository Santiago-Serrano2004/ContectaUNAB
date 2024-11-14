package co.edu.unab.santiagoserrano.contectaunab.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.edu.unab.santiagoserrano.contectaunab.R
import co.edu.unab.santiagoserrano.contectaunab.navigation.AppScreens


@Composable
fun RoleSelectionScreen(onRoleSelected: (String) -> Unit, navController: NavController) {
    // Pantalla completa con fondo morado
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF9C27B0)), // Color morado de fondo
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Texto de selección
        Text(
            text = "¿Cómo deseas ingresar?",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Tarjeta para Estudiante
        RoleCard(
            role = "Estudiante",
            imageRes = R.drawable.estudiante_image, // Reemplaza con el recurso de imagen para Estudiante
            onClick = {
                onRoleSelected("Estudiante")
                navController.navigate(AppScreens.PantallaPrincipalEstudiante.route)
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tarjeta para Tutor
        RoleCard(
            role = "Tutor",
            imageRes = R.drawable.tutor_image, // Reemplaza con el recurso de imagen para Tutor
            onClick = {
                onRoleSelected("Tutor")
                navController.navigate(AppScreens.PantallaPrincipalTutor.route)
            }
        )
    }
}

@Composable
fun RoleCard(role: String, imageRes: Int, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(100.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            // Texto del rol
            Text(
                text = role,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            )

            // Imagen del rol
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "$role Image",
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp)
            )
        }
    }
}
