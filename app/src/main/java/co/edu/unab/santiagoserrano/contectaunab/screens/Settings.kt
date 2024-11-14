package co.edu.unab.santiagoserrano.contectaunab.screens

import android.provider.ContactsContract.CommonDataKinds.Im
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import co.edu.unab.santiagoserrano.contectaunab.R
import co.edu.unab.santiagoserrano.contectaunab.navigation.AppScreens
import com.google.firebase.auth.FirebaseAuth

@Composable
fun Settings(navController: NavController) {
    var notificationsEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Start
        ) {

            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Image(
                    painter = painterResource(id = R.drawable.izquierda),
                    contentDescription = "Back",
                    modifier = Modifier.size(25.dp)
                )
            }
        }


        // Profile Picture
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.Gray) // Placeholder for profile image background
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_icon), // replace with your image resource
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Settings Title
        Text(
            text = "Ajustes",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Notifications Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Notificaciones",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Switch(
                checked = notificationsEnabled,
                onCheckedChange = { notificationsEnabled = it }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Modify Schedule Button
        Button(
            onClick = {
                FirebaseAuth.getInstance().signOut() // Sign out the user in Firebase

                // Ensure the user is fully signed out
                if (FirebaseAuth.getInstance().currentUser == null) {
                    // Navigate back to the login screen and clear the navigation history
                    navController.navigate(AppScreens.PantallaInicio.route) {
                        popUpTo(0)
                    }
                } else {
                    // Handle error if the user is not fully signed out (optional)
                    Log.e("Auth", "Failed to sign out completely.")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 20.dp)
                .height(48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text(
                text = "Cerrar Sesión",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.size(20.dp))

    }
}
