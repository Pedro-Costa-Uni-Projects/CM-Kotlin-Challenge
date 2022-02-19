package pt.ulusofona.cm.kotlin.challenge.models

class Carro(identificador : String, motor : Motor) : Veiculo(identificador) {
    var identificador2 = identificador
    var motor = motor

    override fun requerCarta(): Boolean {
        return true
    }

    override fun toString(): String {
        val convertString = DateFormattor9000().formattor(this.dataDeAquisicao)
        return "Carro | $identificador2 | $convertString | ${this.posicao}"
    }

}