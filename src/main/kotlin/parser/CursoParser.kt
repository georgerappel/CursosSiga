package parser

import model.Curso
import org.jsoup.Jsoup

class CursoParser {
    companion object {
        fun listarCursos() = Jsoup.connect(Curso.SIGA_GRADUACAO).sslSocketFactory(SSLHelperKotlin.socketFactory()).get().run {
            val all = mutableMapOf<String, MutableMap<String, String>>()
            select("tr.tableTitleBlue, tr.tableBodyBlue2").forEach { courseHtml ->
                val courseName = courseHtml.select("b").text()
                val versoes = mutableMapOf<String, String>()

                courseHtml.select("a.linkNormal").forEach {
                    val link = it.attr("href")
                            .replace("temas/zire/frameConsultas.jsp?mainPage=/", "")
                            .replace("javascript:Ementa('", "")
                            .replace("')", "")

                    if (link != "") versoes[it.text()] = link
                }
                all[courseName] = versoes
            }
            all
        }
    }
}