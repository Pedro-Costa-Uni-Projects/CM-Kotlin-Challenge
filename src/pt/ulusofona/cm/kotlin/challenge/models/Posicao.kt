package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException

class Posicao(var x: Integer = Integer(0), var y: Integer = Integer(0)) {

    fun alterarPosicaoPara(x: Int, y: Int) {
        if ((this.x.equals(x)) && (this.y.equals(y))) {
            throw AlterarPosicaoException()
        } else {
            this.x = Integer(x)
            this.y = Integer(y)
        }
    }

    override fun toString(): String {
        return "Posicao | x:$x | y:$y"
    }

}