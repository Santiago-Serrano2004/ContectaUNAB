package co.edu.unab.santiagoserrano.contectaunab

class Horario (
    val lunes: MutableList<Boolean> = MutableList(15) { false },
    val martes: MutableList<Boolean> = MutableList(15) { false },
    val miercoles: MutableList<Boolean> = MutableList(15) { false },
    val jueves : MutableList<Boolean> = MutableList(15) { false },
    val viernes : MutableList<Boolean> = MutableList(15) { false }
) {

}