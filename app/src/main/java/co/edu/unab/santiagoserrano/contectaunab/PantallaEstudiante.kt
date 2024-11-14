package co.edu.unab.santiagoserrano.contectaunab

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.edu.unab.santiagoserrano.contectaunab.navigation.AppScreens


@Composable
fun StudentMainHeader2() { // Agrega los recursos necesarios aquí
    val logoImage: Painter = painterResource(id = R.drawable.conecta_unab2)


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF6A0DAD))
            .size(100.dp)
            .height(200.dp)
            .padding(10.dp)
            .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
    ) {
        Image(
            painter = logoImage,
            contentDescription = "Conecta UNAB Logo",
            modifier = Modifier.size(150.dp)
        )
    }
}

@Composable
fun StudentMainContent2() {
    PerfilEstudiante()
    Spacer(modifier = Modifier.height(16.dp)) // Espacio entre los componentes
    TutoriasProgramadas2()
}


@Preview
@Composable
fun PerfilEstudiante() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagen circular
        Image(
            painter = painterResource(id = R.drawable.profile_icon), // Reemplaza con el recurso de tu imagen
            contentDescription = "Foto del estudiante",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Textos de bienvenida y nombre del tutor
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Bienvenido!",
                fontSize = 18.sp
            )
            Text(
                text = "Nombre Estudiante",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Calificación con estrellas
        Row {
            repeat(3) { // Estrellas doradas
                Icon(
                    painter = painterResource(id = R.drawable.estrella), // Reemplaza con el recurso de tu estrella
                    contentDescription = "Estrella dorada",
                    tint = Color(0xFFFFD700),
                    modifier = Modifier.size(20.dp)
                )
            }
            repeat(2) { // Estrellas grises
                Icon(
                    painter = painterResource(id = R.drawable.estrella), // Reemplaza con el recurso de tu estrella
                    contentDescription = "Estrella gris",
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun TutoriasProgramadas2() {
    // Estado para mostrar o no el botón de cancelación
    var showCancelButton by remember { mutableStateOf(false) }

    // Estado para manejar las tutorías programadas (lista mutable)
    var tutorias2 by remember { mutableStateOf(
        listOf(
            Tutoria("Ecuaciones Diferenciales", "vie. 16 agosto 2-3 p.m", "Nombre Tutor", "Lugar de encuentro"),
            // Agrega más tutorías si es necesario
        )
    )}

    Box(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text("Tutorias Programadas")
    }

    // Mostrar las tutorías programadas
    LazyColumn {
        items(tutorias2) { tutoria ->
            TutoriaCard2(
                tutoria = tutoria,
                showCancelButton = showCancelButton,
                onCancelClick = { tutoria ->
                    // Lógica para cancelar la tutoría
                    tutorias2 = tutorias2.filterNot { it == tutoria } // Elimina la tutoría de la lista
                    showCancelButton = false // Cierra el botón de cancelación
                },
                onClick = { showCancelButton = !showCancelButton }
            )
        }

        item {
            Button(
                onClick = {
                    // Aquí puedes agregar la lógica para agendar una tutoría
                    // Por ejemplo, agregar una nueva tutoría estática a la lista
                    tutorias2 = tutorias2 + Tutoria(
                        "Nuevo Tema de Tutoría",
                        "Lun. 20 noviembre 10-11 a.m",
                        "Nombre Nuevo Tutor",
                        "Nuevo Lugar"
                    )
                },
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A0DAD)) // Color del botón
            ) {
                Text(
                    text = "AGENDAR TUTORÍA",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }


}

@Composable
fun TutoriaCard2(
    tutoria: Tutoria,
    showCancelButton: Boolean,
    onCancelClick: (Tutoria) -> Unit,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }, // Cambiar el estado al hacer clic
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Ícono de la tutoría
                Icon(
                    painter = painterResource(id = R.drawable.birrete), // Reemplaza con el recurso de tu ícono
                    contentDescription = "Icono de Tutoría",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.Gray.copy(alpha = 0.3f)),
                    tint = Color.Black
                )

                Spacer(modifier = Modifier.width(12.dp))

                // Información de la tutoría
                Column {
                    Text(
                        text = tutoria.nombre,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = tutoria.fecha,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "${tutoria.estudiante}, ${tutoria.lugar}",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }

            // Botón de cancelar
            if (showCancelButton) {
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { onCancelClick(tutoria) }, // Al hacer clic, elimina la tutoría
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "CANCELAR",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

data class Tutoria2(
    val nombre: String,
    val fecha: String,
    val estudiante: String,
    val lugar: String
)

@Composable
fun StudentMainNavBar2(navController: NavController) {


    val homeIcon: Painter = painterResource(id = R.drawable.home_icon)
    val notificationIcon: Painter = painterResource(id = R.drawable.notification_icon)
    val settingsIcon: Painter = painterResource(id = R.drawable.settings_icon)
    val profileIcon: Painter = painterResource(id = R.drawable.profile_icon)
    Box(modifier = Modifier
        .background(Color(0xFF6A0DAD)), // Purple background
        contentAlignment = Alignment.Center){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.navigate(AppScreens.PantallaPrincipalEstudiante.route)}) {
                Icon(painter = homeIcon, contentDescription = "Home", tint = Color.White)
            }
            IconButton(onClick = { navController.navigate(AppScreens.Notifications.route) }) {
                Icon(painter = notificationIcon, contentDescription = "Notifications", tint = Color.White)
            }
            IconButton(onClick = {  navController.navigate(AppScreens.Settings.route) }) {
                Icon(painter = settingsIcon, contentDescription = "Settings", tint = Color.White)
            }
            IconButton(onClick = { navController.navigate(AppScreens.Profile.route) }) {
                Icon(painter = profileIcon, contentDescription = "Profile", tint = Color.Unspecified)
            }
        }
    }

}