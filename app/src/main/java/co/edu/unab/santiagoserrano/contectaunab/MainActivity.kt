package co.edu.unab.santiagoserrano.contectaunab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.edu.unab.santiagoserrano.contectaunab.navigation.AppNavigation
import co.edu.unab.santiagoserrano.contectaunab.ui.theme.ContectaUNABTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContectaUNABTheme {
                AppNavigation()
            }
        }
    }
}


