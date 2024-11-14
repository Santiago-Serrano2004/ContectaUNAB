package co.edu.unab.santiagoserrano.contectaunab


data class SolicitudReunion(
    val dia:String,
    val hora:String,
    val tutor: User,
    val estudiante: User,
    val fecha:String
) {
}