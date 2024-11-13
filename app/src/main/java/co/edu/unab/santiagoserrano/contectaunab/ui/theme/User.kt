package co.edu.unab.santiagoserrano.contectaunab.ui.theme

import co.edu.unab.santiagoserrano.contectaunab.Horario
import co.edu.unab.santiagoserrano.contectaunab.Reunion
import co.edu.unab.santiagoserrano.contectaunab.SolicitudReunion

open class User (
    val name:String,
    val id:String,
    val password:String,
    val urlImage:String,
    val email:String,
    val semestre:String,
    val horario:Horario,
    val listaReuniones: MutableList<Reunion>,
    val promedio:Int,
    val listaSolicitudReunion: MutableList<SolicitudReunion>,
    val carrera:String
){


}