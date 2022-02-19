package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel


class Posicao(x: Int = 0, y: Int = 0) : Movimentavel{
    var x = x
    var y = y

    fun alterarPosicaoPara(x: Int, y: Int) {
        if ((this.x == x) and (this.y == y)) {
            throw AlterarPosicaoException()
        } else {
            this.x = x
            this.y = y
        }
    }

    override fun moverPara(x: Int, y: Int) {
        alterarPosicaoPara(x, y)
    }

    override fun toString(): String {
        return "Posicao | x:$x | y:$y"
    }

}