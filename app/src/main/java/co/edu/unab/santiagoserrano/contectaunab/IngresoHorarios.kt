/*
package co.edu.unab.santiagoserrano.contectaunab

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun ScheduleScreen(horario: Horario,onDaySelected: (String) -> Unit,
                   onHourSelected: (String) -> Unit) {

    var expandedDay by remember { mutableStateOf(false) }
    var expandedHour by remember { mutableStateOf(false) }

    var selectedDay by remember { mutableStateOf("Selecciona el día") }
    var selectedHour by remember { mutableStateOf("Selecciona la hora") }

    // Lista de días de lunes a viernes
    val daysOfWeek = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes")

    // Lista de horas de 6 AM a 9 PM
    val hoursOfDay = (6..21).map { hour ->
        val period = if (hour < 12) "AM" else "PM"
        val adjustedHour = if (hour > 12) hour - 12 else hour
        "$adjustedHour:00 $period"
    }

    // Dropdown para los días de la semana
    Box {
        Text(
            text = selectedDay,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable { expandedDay = true }
                .background(Color.Gray, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        )
        DropdownMenu(
            expanded = expandedDay,
            onDismissRequest = { expandedDay = false }
        ) {
            daysOfWeek.forEach { day ->
                DropdownMenuItem(onClick =
                {
                    selectedDay = day
                    onDaySelected(day)
                    expandedDay = false
                    })
                {
                    Text(text = day)
                }
            }
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    // Dropdown para las horas del día
    Box {
        Text(
            text = selectedHour,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable { expandedHour = true }
                .background(Color.Gray, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        )
        DropdownMenu(
            expanded = expandedHour,
            onDismissRequest = { expandedHour = false }
        ) {
            hoursOfDay.forEach { hour ->
                DropdownMenuItem(onClick = {
                    selectedHour = hour
                    onHourSelected(hour)
                    expandedHour = false
                }) {
                    Text(text = hour)
                }
            }
        }
    }
}
*/
