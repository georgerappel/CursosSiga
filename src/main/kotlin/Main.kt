import model.Curso
import parser.CursoParser
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        for(cours in CursoParser.listarCursos()) Curso(cours.key, cours.value)
            for( rawCourse in CursoParser.listarCursos())
                if(rawCourse.key.toLowerCase().contains("computa"))
                    ppRawCourse(rawCourse.key, rawCourse.value)

        Curriculo("1", "https://www.siga.ufrj.br/sira/repositorio-curriculo/FA9F18A7-92A4-F79B-1A98-293E97D8939B.html")
    }
    println("Tempo total: $time")
}

fun ppRawCourse(nome: String, linkVersoes: MutableMap<String, String>) {
    println(nome)
    for(ver in linkVersoes) println("\t${ver.key}: ${ver.value}")
    println()
}


//https://www.siga.ufrj.br/sira/temas/zire/frameConsultas.jsp?mainPage=/repositorio-curriculo/FD213546-92A4-F799-634F-A707E3613326.html