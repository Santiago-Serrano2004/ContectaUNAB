package co.edu.unab.santiagoserrano.contectaunab

open class User (
    val name:String,
    val id:String="",
    val password:String,
    val urlImage:String="",
    val email:String,
    val semestre:String="",
    val horario:Horario=Horario(),
    val listaReunion: MutableList<Reunion> = mutableListOf() ,
    val promedio:Int=0,
    val listaSolicitudReunion: MutableList<SolicitudReunion> = mutableListOf(),
    val carrera:String="",
    var puntuacionTutor: Int=0,
    val listaMaterias:MutableList<String> = mutableListOf(),
    var puntuacionEstudiante: Int=0


){


}