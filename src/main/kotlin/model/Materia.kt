package model

class Materia (val cod: String = "", val nome: String, val credito: Double, val requisitos: List<String> = listOf()) {
    override fun toString() = "$cod $nome $credito $requisitos"
}