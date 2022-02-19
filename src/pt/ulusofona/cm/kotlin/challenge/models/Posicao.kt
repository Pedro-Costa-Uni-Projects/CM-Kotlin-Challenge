package pt.ulusofona.cm.kotlin.challenge.models


class Posicao(x: Int = 0, y: Int = 0) {
    var x = x
    var y = y

    fun alterarPosicaoPara(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    override fun toString(): String {
        return "Posicao | x:$x | y:$y"
    }

}