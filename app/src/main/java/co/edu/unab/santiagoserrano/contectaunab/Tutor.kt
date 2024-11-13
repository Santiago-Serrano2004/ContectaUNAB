package co.edu.unab.santiagoserrano.contectaunab

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(showBackground = true)

fun StudentMainScreen() {

    MaterialTheme(
        typography = Typography,
        shapes = Shapes,
        colorScheme = MaterialTheme.colorScheme
    ) {
        Scaffold(topBar = {StudentMainHeader()},
            content = { paddingValues ->
                // El contenido principal de la pantalla
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues) // Respetamos los valores de padding del Scaffold
                ) {
                    StudentMainContent()
                }
            }
                ,
            bottomBar = { StudentMainNavBar() })




//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.SpaceBetween
//        ) {
//            StudentMainHeader()
//            StudentMainContent()
//            StudentMainNavBar()
//        }
    }
}

@Preview
@Composable
fun StudentMainHeader() { // Agrega los recursos necesarios aquí
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
fun StudentMainContent() {
        PerfilTutor()
        TutoriasProgramadas()
}

@Preview
@Composable
fun PerfilTutor() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagen circular
        Image(
            painter = painterResource(id = R.drawable.profile_icon), // Reemplaza con el recurso de tu imagen
            contentDescription = "Foto del Tutor",
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
                text = "Nombre Tutor",
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
fun TutoriasProgramadas() {
    var showCancelButton by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { showCancelButton = !showCancelButton },
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
                    painter = painterResource(id = R.drawable.ic_launcher_background), // Reemplaza con el recurso de tu ícono
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
                        text = "Ecuaciones Diferenciales",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "vie. 16 agosto 2-3 p.m",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "Nombre Estudiante, Lugar de encuentro",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }

            // Botón de cancelar
            if (showCancelButton) {
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        // Lógica para cancelar la tutoría
                    },
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
@Preview
@Composable
fun StudentMainNavBar() {

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
            IconButton(onClick = { /* Acción para el botón de inicio */ }) {
                Icon(painter = homeIcon, contentDescription = "Home", tint = Color.White)
            }
            IconButton(onClick = { /* Acción para el botón de notificaciones */ }) {
                Icon(painter = notificationIcon, contentDescription = "Notifications", tint = Color.White)
            }
            IconButton(onClick = { /* Acción para el botón de ajustes */ }) {
                Icon(painter = settingsIcon, contentDescription = "Settings", tint = Color.White)
            }
            IconButton(onClick = { /* Acción para el botón de perfil */ }) {
                Icon(painter = profileIcon, contentDescription = "Profile", tint = Color.Unspecified)
            }
        }
    }

}

private val Typography = Typography(
    bodyLarge = androidx.compose.ui.text.TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

private val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

