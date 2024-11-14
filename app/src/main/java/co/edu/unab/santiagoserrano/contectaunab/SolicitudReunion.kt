package co.edu.unab.santiagoserrano.contectaunab

import co.edu.unab.santiagoserrano.contectaunab.ui.theme.User


data class SolicitudReunion(
    val dia:String,
    val hora:String,
    val tutor: User,
    val estudiante: User,
    val fecha:String
) {
}