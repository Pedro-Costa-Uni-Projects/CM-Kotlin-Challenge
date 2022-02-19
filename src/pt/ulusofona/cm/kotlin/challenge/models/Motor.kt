package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
 open class Motor(cavalos : Int = 0, cilindrada : Int = 0) : Ligavel{
    var cavalos = cavalos
    var cilindrada = cilindrada
    var ligado = false

    override fun ligar() {
        this.ligado = true
    }

    override fun desligar() {
        this.ligado = false
    }

    override fun estaLigado(): Boolean {
        return this.ligado
    }

    override fun toString(): String {
        return "Motor | $cavalos | $cilindrada"
    }


}