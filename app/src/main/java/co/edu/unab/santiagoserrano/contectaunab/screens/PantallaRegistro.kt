package co.edu.unab.santiagoserrano.contectaunab.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card


import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import co.edu.unab.santiagoserrano.contectaunab.R
import co.edu.unab.santiagoserrano.contectaunab.navigation.AppScreens


@Composable
fun RegistrationScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF6A0DAD)), // Purple background
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
                modifier = Modifier.size(250.dp),
                alignment = Alignment.CenterEnd
            )

            // Title
            Text(
                text = "REGISTRARSE",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Card(modifier = Modifier.padding(horizontal = 4.dp)) {
                Column(modifier = Modifier.padding(6.dp)) {
                    // ID Input Field
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("ID ESTUDIANTE UNAB") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 3.dp),

                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("PROMEDIO ACUMULADO") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 3.dp),


                    )

                    // Name Input Field
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("NOMBRE") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 3.dp),


                        )

                    // Password Input Field
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("CONTRASEÑA") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 3.dp),
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )

                    // Confirm Password Input Field
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("CONTRASEÑA") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 3.dp),
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )

                    // Email Input Field
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("EMAIL UNAB") },
                        placeholder = { Text("estudiante@unab.edu.co") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )
                }
            }

            Button(
                onClick = {navController.navigate(AppScreens.PantallaSeleccionRol.route)},
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
