package co.edu.unab.santiagoserrano.contectaunab

import co.edu.unab.santiagoserrano.contectaunab.ui.theme.User

class Tutor(
    name: String,
    id: String,
    password: String,
    urlImage: String,
    email: String,
    semestre: String,
    horario: Horario,
    listaReuniones: MutableList<Reunion>,
    promedio:Int,
    listaSolicitudReunion: MutableList<SolicitudReunion>,
    carrera:String,
    var puntuacionTutor: Int,
    val listaAsignaturas:MutableList<String>
) : User(
    name = name,
    id = id,
    password = password,
    urlImage = urlImage,
    email = email,
    semestre = semestre,
    horario = horario,
    listaReuniones = listaReuniones,
    promedio=promedio,
    listaSolicitudReunion=listaSolicitudReunion,
    carrera=carrera
) {

}