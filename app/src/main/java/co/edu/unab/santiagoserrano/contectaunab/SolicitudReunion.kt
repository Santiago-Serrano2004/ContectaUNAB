package co.edu.unab.santiagoserrano.contectaunab


data class SolicitudReunion(
    val dia:String,
    val hora:String,
    val tutor:Tutor,
    val estudiante: Estudiante,
    val fecha:String
) {
}