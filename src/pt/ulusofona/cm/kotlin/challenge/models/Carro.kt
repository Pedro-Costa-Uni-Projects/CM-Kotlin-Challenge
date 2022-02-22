package pt.ulusofona.cm.kotlin.challenge.models

class Carro(identificador : String, motor : Motor) : Veiculo(identificador){
    override var cavalos = motor.cavalos
    override var cilindrada = motor.cilindrada
    override var ligado = false

    override fun requerCarta(): Boolean {
        return true
    }

    override fun toString(): String {
        val convertString = DateFormattor9000().formattor(this.dataDeAquisicao)
        return "Carro | $identificador | $convertString | ${this.posicao}"
    }

}