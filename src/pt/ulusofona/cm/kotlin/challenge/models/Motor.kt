package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
 open class Motor(cavalos : Int = 0, cilindrada : Int = 0) : Ligavel{
    var cavalos = cavalos
    var cilindrada = cilindrada
    var ligado = true

    override fun ligar() {
        if (this.ligado) {
            throw VeiculoLigadoException()
        } else {
            this.ligado = true
        }
    }

    override fun desligar() {
        if (!this.ligado) {
            throw VeiculoDesligadoException()
        } else {
            this.ligado = false
        }
    }

    override fun estaLigado(): Boolean {
        return this.ligado
    }

    override fun toString(): String {
        return "Motor | $cavalos | $cilindrada"
    }


}