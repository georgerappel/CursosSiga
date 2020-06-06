package model

import Curriculo

class Curso(val nome: String, linkVersoes: MutableMap<String, String>) {
    val versoesCurriculares = mutableMapOf<String, Curriculo>()

    init {
        for(id in linkVersoes) {
            versoesCurriculares[id.key] = Curriculo(id.key, LINK + id.value)
        }
    }

    companion object {
        const val LINK = "https://www.siga.ufrj.br"
        const val SIGA_GRADUACAO = "https://www.siga.ufrj.br/sira/repositorio-curriculo/80167CF7-3880-478C-8293-8E7D80CEDEBE.html"
    }
}