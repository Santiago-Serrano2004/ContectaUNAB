package co.edu.unab.santiagoserrano.contectaunab.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import co.edu.unab.santiagoserrano.contectaunab.R
import co.edu.unab.santiagoserrano.contectaunab.navigation.AppScreens
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun RegistrationScreen(navController: NavController) {
    val auth = FirebaseAuth.getInstance()
    val db = FirebaseFirestore.getInstance()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    fun registerUser() {
        // Verificar si los campos están vacíos
        if (email.isBlank() || password.isBlank() || confirmPassword.isBlank() || name.isBlank()) {
            errorMessage = "Todos los campos son obligatorios."
            return
        }

        // Verificar si las contraseñas coinciden
        if (password != confirmPassword) {
            errorMessage = "Las contraseñas no coinciden"
            return
        }

        // Validar el formato del email
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            errorMessage = "Por favor ingrese un correo electrónico válido."
            return
        }

        // Intentar crear el usuario
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Si la creación del usuario fue exitosa
                    val userId = auth.currentUser?.uid
                    val user = mapOf(
                        "name" to name,
                        "email" to email,
                        "rol" to "estudiante"
                    )

                    userId?.let {
                        // Guardar los datos del usuario en Firestore
                        db.collection("users").document(it).set(user)
                            .addOnSuccessListener {
                                // Navegar a la pantalla de selección de rol
                                navController.navigate(AppScreens.PantallaSeleccionRol.route)
                            }
                            .addOnFailureListener { exception ->
                                // Error al guardar en Firestore
                                errorMessage = "Error al guardar datos en Firestore: ${exception.message}"
                                Log.e("FirestoreError", exception.message ?: "Unknown error")
                            }
                    }
                } else {
                    // Mostrar el mensaje de error si la creación del usuario falla
                    errorMessage = task.exception?.message ?: "Error al registrarse"
                    Log.e("RegistrationError", task.exception?.toString() ?: "Unknown error")
                }
            }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF6A0DAD)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.unab_logo),
                contentDescription = "Logo UNAB",
                modifier = Modifier.size(250.dp)
            )

            Text(
                text = "REGISTRARSE",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Card(modifier = Modifier.padding(horizontal = 4.dp)) {
                Column(modifier = Modifier.padding(6.dp)) {
                    // Campo para el nombre
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("NOMBRE") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 3.dp)
                    )

                    // Campo para el email
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("EMAIL") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )

                    // Campo para la contraseña
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("CONTRASEÑA") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 3.dp),
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )

                    // Campo para confirmar la contraseña
                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        label = { Text("CONFIRMAR CONTRASEÑA") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 3.dp),
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )

                    // Mostrar mensaje de error si existe
                    if (errorMessage.isNotEmpty()) {
                        Text(
                            text = errorMessage,
                            color = Color.Red,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }

            // Botón de registro
            Button(
                onClick = { registerUser() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text(
                    text = "REGISTRARSE",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
